package com.sonna.common.utils

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(
        val errorCode: Int?,
        val errorBody: Any?
    ) : Resource<Nothing>()

    data object Loading : Resource<Nothing>()
}