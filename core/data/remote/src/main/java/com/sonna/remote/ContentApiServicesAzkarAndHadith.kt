package com.sonna.remote

import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.hadith.HadithResponse
import retrofit2.Response
import retrofit2.http.GET

interface ContentApiServicesAzkarAndHadith {
    @GET("Azkar/azkar.json")
    suspend fun getAzkar(): AzkarResponse

    @GET("Hadith/darimi.json")
    suspend fun getDarimiBook():  Response<HadithResponse>
    @GET("Hadith/ahmed.json")
    suspend fun getAhmedBook():  Response<HadithResponse>
    @GET("Hadith/abi_daud.json")
    suspend fun getAbiDaudBook():  Response<HadithResponse>
    @GET("Hadith/bukhari.json")
    suspend fun getBukariBook(): Response<HadithResponse>
    @GET("Hadith/ibn_maja.json")
    suspend fun getIbnMajaBook():  Response<HadithResponse>
    @GET("Hadith/malik.json")
    suspend fun getMalikBook():  Response<HadithResponse>
    @GET("Hadith/muslim.json")
    suspend fun getMuslimBook():  Response<HadithResponse>
    @GET("Hadith/nasai.json")
    suspend fun getNasaiBook():  Response<HadithResponse>
    @GET("Hadith/trmizi.json")
    suspend fun getTrmiziBook():  Response<HadithResponse>

}