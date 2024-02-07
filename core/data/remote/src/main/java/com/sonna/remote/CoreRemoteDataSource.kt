package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.quran.QuranResponse
import kotlinx.coroutines.flow.Flow

interface CoreRemoteDataSource {
    suspend fun getQuran(): Flow<QuranResponse>
    suspend fun getAzkar(): Flow<AzkarResponse>
}