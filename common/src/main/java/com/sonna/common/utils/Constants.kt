package com.sonna.common.utils

object Constants {
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    object EndPoints {
        const val POSTS = "posts"
        const val POST_DETAILS = "posts/{id}"
    }

    enum class HTTP_CODES(val code: Int) {
        CODE_URL_NOT_FOUND(404),
        CODE_INTERNAL_SERVER_ERROR(500),
        CONNECTION_ERROR(0),
    }
}