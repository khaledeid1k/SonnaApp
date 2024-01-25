package com.sonna.local

import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

interface ContentLocalDataSource {
    suspend fun insertSurah(surahModel: SurahModel):Long
    suspend fun insertZekr(zekrModel: ZekrModel):Long
    suspend fun getAzkar():List<ZekrModel>
}