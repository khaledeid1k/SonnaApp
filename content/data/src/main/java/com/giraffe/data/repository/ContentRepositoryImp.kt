package com.giraffe.data.repository

import com.giraffe.data.local.ContentLocalDataSource
import com.giraffe.data.remote.ContentRemoteDataSource
import com.giraffe.domain.entity.quran.AllSurahesEntity
import com.giraffe.domain.entity.quran.SurahEntity
import com.giraffe.domain.repository.ContentRepository

class ContentRepositoryImp(
    private val remoteDataSource: ContentRemoteDataSource,
    private val contentLocalDataSource: ContentLocalDataSource
): ContentRepository {
    override suspend fun getSurahes(): AllSurahesEntity {
        return remoteDataSource.getSurahes().toEntity()
    }
    override suspend fun insertSurah(surahEntity: SurahEntity): Long {
        return contentLocalDataSource.insertSurah(surahEntity.toModel())
    }
}