package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.quran.AllSurahesResponse
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers

interface ContentApiServicesAzkar {
    //@Headers("Accept: application/json;charset=UTF-8")
    @GET("azkar.json")
    suspend fun getAzkar(): AzkarResponse
}