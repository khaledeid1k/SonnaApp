package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.hadith.HadithResponse
import com.sonna.remote.response.quran.AllSurahesResponse
import retrofit2.Response

interface ContentRemoteDataSource {
    suspend fun getSurahes(): AllSurahesResponse
    suspend fun getAzkar(): AzkarResponse
    suspend fun getDarimiHadithBook():  Response<HadithResponse>
    suspend fun getAhmedBook():  Response<HadithResponse>
    suspend fun getAbiDaudBook():  Response<HadithResponse>
    suspend fun getBukariBook():  Response<HadithResponse>
    suspend fun getIbnMajaBook(): Response<HadithResponse>
    suspend fun getMalikBook():  Response<HadithResponse>
    suspend fun getMuslimBook():  Response<HadithResponse>
    suspend fun getNasaiBook():  Response<HadithResponse>
    suspend fun getTrmiziBook():  Response<HadithResponse>

    fun downloadFile(url: String, hadithBookName: String): Long

}