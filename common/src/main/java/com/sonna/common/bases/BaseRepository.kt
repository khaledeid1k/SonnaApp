package com.sonna.common.bases

import android.util.Log
import com.sonna.common.utils.ErrorType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.Response
import java.net.UnknownHostException

abstract class BaseRepository {
    suspend fun <T> wrapResponseWithErrorHandler(
        function: suspend () -> Flow<Response<T>>
    ): Flow<T> {
        return flow {
            try {
                function().catch {
                    Log.v("ameerxy", "ErrorType.Flow")
                    throw ErrorType.Flow(it.message ?: "Unknown Error")
                }.collect {
                    if (it.isSuccessful) {
                        Log.v("ameerxy", "isSuccessful")
                        if (it.body() != null && it.isSuccessful) {
                            Log.v("ameerxy", "baseResponValidationResultse.isSuccess ${it.body()}")
                            emit(it.body()!!)
                        } else {
                            Log.v("ameerxy", "ErrorType.Server")
                            throw ErrorType.Server(it.message())
                        }
                    } else {
                        val errorResponse = JSONObject(it.errorBody()?.string()!!)
                        Log.v("ameerxy", "ErrorType.Server => $errorResponse")
                        throw ErrorType.Server(
                            errorResponse.getString("data") ?: "Network Error"
                        )
                    }
                }
            } catch (e: UnknownHostException) {
                Log.v("ameerxy", "ErrorType.Network")
                throw ErrorType.Network("Network Error")
            }
        }

    }

    suspend fun <T> wrapLocalResponseWithErrorHandler(
        function: suspend () -> Flow<T>
    ): Flow<T> {
        return flow {
            try {
                function().catch {
                    throw ErrorType.Flow(it.message ?: "Unknown Error")
                }.collect {
                    emit(it)
                }
            } catch (e: UnknownHostException) {
                throw ErrorType.Network("Network Error")
            }
        }

    }
}