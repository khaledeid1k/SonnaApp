package com.sonna.remote

import com.sonna.remote.response.quran.QuranResponse
import retrofit2.http.GET

interface CoreApiServicesQuran {
    @GET("quran/quran-uthmani")
    suspend fun getQuran(): QuranResponse
}