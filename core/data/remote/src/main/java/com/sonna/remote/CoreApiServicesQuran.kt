package com.sonna.remote

import com.sonna.remote.response.quran.QuranResponse
import retrofit2.http.GET

interface CoreApiServicesQuran {
    @GET("")
    suspend fun getQuran(): QuranResponse
}