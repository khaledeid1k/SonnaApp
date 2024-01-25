package com.sonna.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.ContentRepository
import com.sonna.local.ContentLocalDataSource
import com.sonna.remote.ContentRemoteDataSource

class ContentRepositoryImp(
    private val contentRemoteDataSource: ContentRemoteDataSource,
    private val contentLocalDataSource: ContentLocalDataSource
) : ContentRepository {
    override suspend fun getSurahes(): AllSurahesEntity {
        return contentRemoteDataSource.getSurahes().toEntity()
    }

    override suspend fun getAzkar(fromLocal: Boolean): AzkarEntity {
        return if (fromLocal) {
            AzkarEntity(contentLocalDataSource.getAzkar().map { it.toEntity() })
        } else {
            contentRemoteDataSource.getAzkar().toEntity()
        }
    }

    override suspend fun getSLastHadith(): String {
        return "hadith"
    }

    override suspend fun insertSurah(surahEntity: SurahEntity) =
        contentLocalDataSource.insertSurah(surahEntity.toModel())

    override suspend fun insertZekr(zekrEntity: ZekrEntity) =
        contentLocalDataSource.insertZekr(zekrEntity.toModel())
}