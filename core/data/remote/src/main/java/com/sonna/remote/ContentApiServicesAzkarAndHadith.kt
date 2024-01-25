package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.hadith.HadithResponse
import retrofit2.http.GET

interface ContentApiServicesAzkarAndHadith {
    @GET("Azkar/azkar.json")
    suspend fun getAzkar(): AzkarResponse

    @GET("Hadith/darimi.json")
    suspend fun getDarimiBook(): HadithResponse
}