package com.giraffe.data.remote

import com.giraffe.data.remote.response.quran.AllSurahesResponse
import retrofit2.http.GET

interface ContentApiServices {
    @GET("/surah")
    suspend fun getSurahes():AllSurahesResponse
}