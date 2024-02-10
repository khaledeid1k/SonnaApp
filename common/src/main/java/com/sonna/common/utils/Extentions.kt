package com.sonna.common.utils

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.HttpException

suspend fun <T> safeCall(apiCall: suspend () -> Flow<T>): Resource<T> {
    return withContext(Dispatchers.IO) {
        var resource: Resource<T> = Resource.Loading
        try {
            apiCall.invoke()
                .catch {
                    resource = Resource.Failure(0, it)
                }.collect {
                    resource = if (it is Response<*>) {
                        if (it.isSuccessful && it.body() != null) {
                            Resource.Success(it)
                        } else {
                            Resource.Failure(it.code(), it.errorBody())
                        }
                    } else {
                        Resource.Success(it)
                    }
                }
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    resource = Resource.Failure(
                        throwable.code(),
                        throwable.response()!!.errorBody() as ResponseBody
                    )
                }

                is JsonSyntaxException -> {
                    resource = Resource.Failure(
                        0,
                        throwable.localizedMessage
                    )
                }

                else -> {
                    resource = Resource.Failure(0, null)
                }
            }
        }
        resource
    }
}

fun handleApiErrors(
    failure: Resource.Failure,
): String {
    return when (failure.errorCode) {
        Constants.HTTP_CODES.CODE_INTERNAL_SERVER_ERROR.code -> {
            "something went wrong (CODE_INTERNAL_SERVER_ERROR)"
        }

        Constants.HTTP_CODES.CODE_URL_NOT_FOUND.code -> {
            "something went wrong (CODE_URL_NOT_FOUND)"
        }

        Constants.HTTP_CODES.CONNECTION_ERROR.code -> {
            "something went wrong (CONNECTION_ERROR)"
        }

        else -> {
            when (failure.errorBody) {
                is ResponseBody -> {
                    val error = failure.errorBody.string()
                    val baseResponse = Gson().fromJson(error, ErrorResponse::class.java)
                    "something went wrong (${baseResponse?.message ?: "something went wrong"})"
                }

                is String -> {
                    "something went wrong (${failure.errorBody})"
                }

                else -> {
                    "something went wrong"
                }
            }
        }
    }
}

data class ErrorResponse(
    val message: String,
)