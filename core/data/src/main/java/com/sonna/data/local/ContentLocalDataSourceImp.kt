package com.sonna.data.local

import com.sonna.data.local.model.SurahModel

class ContentLocalDataSourceImp(
    private val contentDao: ContentDao,
) : ContentLocalDataSource {
    override suspend fun insertSurah(surahModel: SurahModel) = contentDao.insertSurah(surahModel)
}