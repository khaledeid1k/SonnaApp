package com.sonna.repository

import com.sonna.domain.entity.ErrorType
import retrofit2.Response


open class BaseRepository {

    suspend fun <T> wrapResponse(
        call: suspend () -> Response<T>,
    ): T {
        try {
            val call1 = call()
            if (call1.isSuccessful && call1.body() != null) {
                return call1.body()!!
            } else {
                throw ErrorType.ServerError()
            }
        } catch (e: ErrorType) {
            throw ErrorType.NetworkError()
        }
    }

}