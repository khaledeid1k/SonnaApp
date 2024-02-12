package com.sonna.domain.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.entity.quran.SurahEntity
import kotlinx.coroutines.flow.Flow

interface CoreRepository {
    suspend fun getQuran(): Flow<QuranEntity>
    suspend fun getAzkar(fromLocal:Boolean): Flow<AzkarEntity>
    suspend fun insertSurah(surahEntity: SurahEntity):Flow<Long>
    suspend fun insertZekr(zekrEntity: ZekrEntity):Long
}