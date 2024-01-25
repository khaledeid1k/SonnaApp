package com.sonna.remote

import com.sonna.remote.response.hadith.HadithResponse
import com.sonna.remote.response.quran.AllSurahesResponse
import retrofit2.http.GET

interface ContentApiServices {
    @GET("/surah")
    suspend fun getSurahes(): AllSurahesResponse
    @GET("khaledeid1k/repos_server/main/Hadith%20Books%20Json/darimi.json")
    suspend fun getDarimiBook():HadithResponse
}