package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.quran.QuranResponse

interface CoreRemoteDataSource {
    suspend fun getQuran(): QuranResponse
    suspend fun getAzkar(): AzkarResponse
}