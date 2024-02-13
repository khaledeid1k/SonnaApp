package com.sonna.local

import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel
import kotlinx.coroutines.flow.Flow

interface CoreLocalDataSource {
    suspend fun insertSurah(surahModel: SurahModel): Flow<Long>
    suspend fun getQuran(): Flow<List<SurahModel>>
    suspend fun getSurah(surahIndex: Int): Flow<SurahModel>
    suspend fun insertZekr(zekrModel: ZekrModel): Long
    suspend fun getAzkar(): Flow<List<ZekrModel>>
}