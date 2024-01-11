package com.sonna.data.repository

import com.sonna.data.local.ContentLocalDataSource
import com.sonna.data.remote.ContentRemoteDataSource
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.ContentRepository

class ContentRepositoryImp(
    private val remoteDataSource: ContentRemoteDataSource,
    private val contentLocalDataSource: ContentLocalDataSource
): ContentRepository {
    override suspend fun getSurahes(): com.sonna.domain.entity.quran.AllSurahesEntity {
        return remoteDataSource.getSurahes().toEntity()
    }
    override suspend fun insertSurah(surahEntity: com.sonna.domain.entity.quran.SurahEntity): Long {
        return contentLocalDataSource.insertSurah(surahEntity.toModel())
    }
}