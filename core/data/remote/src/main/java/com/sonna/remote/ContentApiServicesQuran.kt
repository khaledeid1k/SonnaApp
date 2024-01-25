package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.quran.AllSurahesResponse
import retrofit2.http.GET

interface ContentApiServicesQuran {
    @GET("/surah")
    suspend fun getSurahes(): AllSurahesResponse
}