package com.sonna.domain.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.entity.quran.SurahEntity

interface CoreRepository {
    suspend fun getQuran(): QuranEntity
    suspend fun getAzkar(fromLocal:Boolean): AzkarEntity
    suspend fun insertSurah(surahEntity: SurahEntity):Long
    suspend fun insertZekr(zekrEntity: ZekrEntity):Long
}