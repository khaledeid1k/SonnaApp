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
    tryAgainAction: () -> Unit
) {
    when (failure.errorCode) {
        Constants.HTTP_CODES.CODE_INTERNAL_SERVER_ERROR.code -> {
            //showSnackBar("something went wrong", tryAgainAction)
        }

        Constants.HTTP_CODES.CODE_URL_NOT_FOUND.code -> {
            //showSnackBar("something went wrong", tryAgainAction)
        }

        Constants.HTTP_CODES.CONNECTION_ERROR.code -> {
            //showSnackBar("check your internet connection", tryAgainAction)
        }

        else -> {
            if (failure.errorBody is ResponseBody) {
                val error = failure.errorBody.string()
                val baseResponse = Gson().fromJson(error, ErrorResponse::class.java)
                //showSnackBar(baseResponse?.message ?: "something went wrong", tryAgainAction)
            } else if (failure.errorBody is String) {
                //showSnackBar(failure.errorBody, tryAgainAction)
            }
        }
    }
}

data class ErrorResponse(
    val message: String,
)