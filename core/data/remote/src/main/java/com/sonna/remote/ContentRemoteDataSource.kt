package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.quran.AllSurahesResponse

interface ContentRemoteDataSource {
    suspend fun getSurahes(): AllSurahesResponse
    suspend fun getAzkar(): AzkarResponse
}