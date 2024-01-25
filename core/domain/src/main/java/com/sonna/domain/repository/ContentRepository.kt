package com.sonna.domain.repository

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity

interface ContentRepository {
    suspend fun getSurahes(): AllSurahesEntity
    suspend fun getSLastHadith(): String
    suspend fun insertSurah(surahEntity: SurahEntity):Long
    suspend fun getHadithDarimi():  List<HadithEntity>
}