package com.sonna.repository

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.hadith.HadithBookName
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.ContentRepository
import com.sonna.local.ContentLocalDataSource
import com.sonna.remote.ContentRemoteDataSource
import com.sonna.remote.response.hadith.HadithResponse

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


    override suspend fun saveSelectedHadithBook(hadithBook: String) {
        contentLocalDataSource.saveSelectedHadithBook(hadithBook)
    }

    override suspend fun readSelectedHadithBook(): String {
        return contentLocalDataSource.readSelectedHadithBook()
    }

    override suspend fun getHadithBook(): List<HadithEntity> {
        val bookFetcherMap = mapOf<String, suspend () -> HadithResponse>(
            HadithBookName.darimi.name to contentRemoteDataSource::getDarimiHadithBook,
            HadithBookName.ahmed.name to contentRemoteDataSource::getAhmedBook,
            HadithBookName.abi_daud.name to contentRemoteDataSource::getAbiDaudBook,
            HadithBookName.bukhari.name to contentRemoteDataSource::getBukariBook,
            HadithBookName.ibn_maja.name to contentRemoteDataSource::getIbnMajaBook,
            HadithBookName.malik.name to contentRemoteDataSource::getMalikBook,
            HadithBookName.muslim.name to contentRemoteDataSource::getMuslimBook,
            HadithBookName.nasai.name to contentRemoteDataSource::getNasaiBook,
            HadithBookName.trmizi.name to contentRemoteDataSource::getTrmiziBook,
        )

        return bookFetcherMap[readSelectedHadithBook()]?.invoke()?.toEntity() ?: emptyList()
    }
}