package com.sonna.local

import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel
import kotlinx.coroutines.flow.Flow

interface CoreLocalDataSource {
    suspend fun insertSurah(surahModel: SurahModel):Long
    suspend fun insertZekr(zekrModel: ZekrModel):Long
    suspend fun getAzkar():Flow<List<ZekrModel>>
}