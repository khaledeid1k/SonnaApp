package com.sonna.data.remote

import com.sonna.data.remote.response.quran.AllSurahesResponse
import retrofit2.http.GET

interface ContentApiServices {
    @GET("/surah")
    suspend fun getSurahes(): AllSurahesResponse
}