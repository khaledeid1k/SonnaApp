package com.sonna.local

import com.sonna.local.data_store.SonnaDataStorePreferences
import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

class ContentLocalDataSourceImp(
    private val contentDao: ContentDao,
    private val sonnaDataStorePreferences: SonnaDataStorePreferences
) : ContentLocalDataSource {
    override suspend fun insertSurah(surahModel: SurahModel) = contentDao.insertSurah(surahModel)
    override suspend fun readSelectedHadithBook(): String {
       return sonnaDataStorePreferences.readSelectedHadithBook()
    }

    override suspend fun saveSelectedHadithBook(hadithBook: String) {
        sonnaDataStorePreferences.saveSelectedHadithBook(hadithBook)
    }
    override suspend fun insertZekr(zekrModel: ZekrModel) = contentDao.insertZekr(zekrModel)
    override suspend fun getAzkar() = contentDao.getAzkar()
}