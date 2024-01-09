package com.giraffe.data.local

import com.giraffe.data.local.model.SurahModel

class ContentLocalDataSourceImp(
    private val contentDao: ContentDao,
) : ContentLocalDataSource {
    override suspend fun insertSurah(surahModel: SurahModel) = contentDao.insertSurah(surahModel)
}