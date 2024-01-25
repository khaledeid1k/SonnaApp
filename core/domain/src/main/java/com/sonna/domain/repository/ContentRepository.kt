package com.sonna.domain.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity

interface ContentRepository {
    suspend fun getSurahes(): AllSurahesEntity
    suspend fun getAzkar(): AzkarEntity
    suspend fun getSLastHadith(): String
    suspend fun insertSurah(surahEntity: SurahEntity):Long
}