package com.sonna.domain.repository

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity

interface ContentRepository {
    suspend fun getSurahes(): AllSurahesEntity
    suspend fun getAzkar(fromLocal:Boolean): AzkarEntity
    suspend fun getSLastHadith(): String
    suspend fun insertSurah(surahEntity: SurahEntity):Long
    suspend fun insertZekr(zekrEntity: ZekrEntity):Long

    suspend fun getHadithDarimi(): List<HadithEntity>
    suspend  fun saveSelectedHadithBook(hadithBook: String)
    suspend  fun getSelectedTHadithBook(): String
}