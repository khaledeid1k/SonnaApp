package com.sonna.data.remote

import com.sonna.data.remote.response.quran.AllSurahesResponse

interface ContentRemoteDataSource {
    suspend fun getSurahes(): AllSurahesResponse
}