package com.sonna.remote

import com.sonna.remote.response.hadith.HadithResponse
import com.sonna.remote.response.quran.AllSurahesResponse

interface ContentRemoteDataSource {
    suspend fun getSurahes(): AllSurahesResponse
    suspend fun getDarimiBook(): HadithResponse
}