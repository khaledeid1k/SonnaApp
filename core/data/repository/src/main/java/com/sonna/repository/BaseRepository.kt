package com.sonna.repository

import com.sonna.domain.entity.ErrorType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

open class BaseRepository {

    fun <T> wrapResponse(
        call: suspend () -> Response<T>,
    ): Flow<T> {
        return flow<T> {
            val call1 = call()
            if (call1.isSuccessful) {
                call1.body()
            } else {
                throw ErrorType.NetworkError()
            }
        }.catch {
            throw ErrorType.UnKnownError()
        }

    }
}