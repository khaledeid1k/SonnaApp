package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.hadith.HadithResponse
import retrofit2.http.GET

interface ContentApiServicesAzkarAndHadith {
    @GET("Azkar/azkar.json")
    suspend fun getAzkar(): AzkarResponse

    @GET("Hadith/darimi.json")
    suspend fun getDarimiBook(): HadithResponse
    @GET("Hadith/ahmed.json")
    suspend fun getAhmedBook(): HadithResponse
    @GET("Hadith/abi_daud.json")
    suspend fun getAbiDaudBook(): HadithResponse
    @GET("Hadith/bukhari.json")
    suspend fun getBukariBook(): HadithResponse
    @GET("Hadith/ibn_maja.json")
    suspend fun getIbnMajaBook(): HadithResponse
    @GET("Hadith/malik.json")
    suspend fun getMalikBook(): HadithResponse
    @GET("Hadith/muslim.json")
    suspend fun getMuslimBook(): HadithResponse
    @GET("Hadith/nasai.json")
    suspend fun getNasaiBook(): HadithResponse
    @GET("Hadith/trmizi.json")
    suspend fun getTrmiziBook(): HadithResponse

}