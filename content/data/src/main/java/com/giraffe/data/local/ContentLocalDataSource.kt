package com.giraffe.data.local

import com.giraffe.data.local.model.SurahModel

interface ContentLocalDataSource {
    suspend fun insertSurah(surahModel: SurahModel):Long
}