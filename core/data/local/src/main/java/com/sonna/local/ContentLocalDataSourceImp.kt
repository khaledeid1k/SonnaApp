package com.sonna.local

import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

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
    override suspend fun insertZekr(zekrModel: ZekrModel) = contentDao.insertZekr(zekrModel)
    override suspend fun getAzkar() = contentDao.getAzkar()
}