package com.sonna.remote

import com.sonna.remote.response.hadith.HadithResponse
import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.quran.AllSurahesResponse

interface ContentRemoteDataSource {
    suspend fun getSurahes(): AllSurahesResponse
    suspend fun getAzkar(): AzkarResponse
    suspend fun getDarimiHadithBook(): HadithResponse
    suspend fun getAhmedBook(): HadithResponse
    suspend fun getAbiDaudBook(): HadithResponse
    suspend fun getBukariBook(): HadithResponse
    suspend fun getIbnMajaBook(): HadithResponse
    suspend fun getMalikBook(): HadithResponse
    suspend fun getMuslimBook(): HadithResponse
    suspend fun getNasaiBook(): HadithResponse
    suspend fun getTrmiziBook(): HadithResponse
}