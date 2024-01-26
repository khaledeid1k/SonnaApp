package com.sonna.local

import com.sonna.data.local.model.SurahModel
import com.sonna.local.data_store.SonnaPreferences

class ContentLocalDataSourceImp(
    private val contentDao: ContentDao,
    private val sonnaPreferences: SonnaPreferences
) : ContentLocalDataSource {
    override suspend fun insertSurah(surahModel: SurahModel) = contentDao.insertSurah(surahModel)
    override suspend fun getSelectedTHadithBook(): String {
       return sonnaPreferences.readSelectedHadithBook()
    }

    override suspend fun saveSelectedHadithBook(hadithBook: String) {
        sonnaPreferences.saveSelectedHadithBook(hadithBook)
    }
}