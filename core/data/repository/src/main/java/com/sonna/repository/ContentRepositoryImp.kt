package com.sonna.repository

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.local.model.HadithBookNames
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.ContentRepository
import com.sonna.local.ContentLocalDataSource
import com.sonna.mapper.toEntity
import com.sonna.mapper.toModel
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

    override suspend fun readSelectedHadithBook(): Pair<String,Int> {
        val readSelectedHadithBook = contentLocalDataSource.readSelectedHadithBookName()
        val hadithBook = HadithBookNames.fromName(readSelectedHadithBook)
        val numberOfHadithBook = hadithBook.numberOfHadithBook
        return Pair(readSelectedHadithBook,numberOfHadithBook)
    }


    override suspend fun getHadithBook(): List<HadithEntity> {
        val bookFetcherMap = mapOf<String, suspend () -> HadithResponse>(
            HadithBookNames.Darimi.name to contentRemoteDataSource::getDarimiHadithBook,
            HadithBookNames.Ahmed.name to contentRemoteDataSource::getAhmedBook,
            HadithBookNames.AbiDaud.name to contentRemoteDataSource::getAbiDaudBook,
            HadithBookNames.Bukhari.name to contentRemoteDataSource::getBukariBook,
            HadithBookNames.IbnMaja.name to contentRemoteDataSource::getIbnMajaBook,
            HadithBookNames.Malik.name to contentRemoteDataSource::getMalikBook,
            HadithBookNames.Muslim.name to contentRemoteDataSource::getMuslimBook,
            HadithBookNames.Nasai.name to contentRemoteDataSource::getNasaiBook,
            HadithBookNames.Trmizi.name to contentRemoteDataSource::getTrmiziBook,
        )

        return bookFetcherMap[readSelectedHadithBook().first]?.invoke()?.toEntity() ?: emptyList()
    }



    override suspend fun saveHadithBook(hadithBook: List<HadithEntity>): List<Long> {
        return contentLocalDataSource.saveHadithBook(hadithBook.toModel())
    }

    override suspend fun getHadith(
        hadithBookName: String,
        numberOfHadith: Int
    ): HadithEntity {
        return contentLocalDataSource.getHadith(hadithBookName, numberOfHadith).toEntity()
    }
}