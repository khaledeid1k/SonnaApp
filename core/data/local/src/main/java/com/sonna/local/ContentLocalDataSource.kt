package com.sonna.local

import com.sonna.data.local.model.SurahModel
import kotlinx.coroutines.flow.Flow

interface ContentLocalDataSource {
    suspend fun insertSurah(surahModel: SurahModel):Long
    suspend  fun getSelectedTHadithBook(): String
    suspend  fun saveSelectedHadithBook(hadithBook: String)
}