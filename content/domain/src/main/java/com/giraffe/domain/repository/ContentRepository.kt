package com.giraffe.domain.repository

import com.giraffe.domain.entity.quran.AllSurahesEntity
import com.giraffe.domain.entity.quran.SurahEntity

interface ContentRepository {
    suspend fun getSurahes():AllSurahesEntity
    suspend fun insertSurah(surahEntity: SurahEntity):Long
}