package com.sonna.local

import com.sonna.data.local.model.SurahModel

interface ContentLocalDataSource {
    suspend fun insertSurah(surahModel: SurahModel):Long
}