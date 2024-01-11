package com.sonna.remote

import com.sonna.remote.response.quran.AllSurahesResponse
import retrofit2.http.GET

interface ContentApiServices {
    @GET("/surah")
    suspend fun getSurahes(): AllSurahesResponse
}