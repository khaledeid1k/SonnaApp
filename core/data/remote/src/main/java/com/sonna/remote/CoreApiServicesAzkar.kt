package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoreApiServicesAzkar {
    //@Headers("Accept: application/json;charset=UTF-8")
    @GET("azkar.json")
    suspend fun getAzkar(): Response<AzkarResponse>
}