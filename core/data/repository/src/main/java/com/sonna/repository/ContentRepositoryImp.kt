package com.sonna.repository

import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.ContentRepository
import com.sonna.local.ContentLocalDataSource
import com.sonna.remote.ContentRemoteDataSource

class ContentRepositoryImp(
    private val remoteDataSource: ContentRemoteDataSource,
    private val contentLocalDataSource: ContentLocalDataSource
): ContentRepository {
    override suspend fun getSurahes(): AllSurahesEntity {
        return remoteDataSource.getSurahes().toEntity()
    }

    override suspend fun getSLastHadith(): String {
        return "hadith"
    }

    override suspend fun insertSurah(surahEntity: SurahEntity): Long {
        return contentLocalDataSource.insertSurah(surahEntity.toModel())
    }

    override suspend fun saveSelectedHadithBook(hadithBook: String) {
        contentLocalDataSource.saveSelectedHadithBook(hadithBook)
    }

    override suspend fun getSelectedTHadithBook():String {
      return  contentLocalDataSource.getSelectedTHadithBook()

    }
}