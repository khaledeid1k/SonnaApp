package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.quran.QuranResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CoreRemoteDataSource {
    suspend fun getQuran(): Flow<Response<QuranResponse>>
    suspend fun getAzkar(): Flow<Response<AzkarResponse>>
}