package com.sonna.domain.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.entity.quran.SurahEntity
import kotlinx.coroutines.flow.Flow

interface CoreRepository {
    suspend fun getQuran(fromLocal:Boolean): Flow<QuranEntity>
    suspend fun getSurah(surahIndex:Int): Flow<SurahEntity>
    suspend fun getAzkar(fromLocal:Boolean,category:String): Flow<AzkarEntity>
    suspend fun insertSurah(surahEntity: SurahEntity):Flow<Long>
    suspend fun insertZekr(zekrEntity: ZekrEntity):Flow<Long>
}