package com.sonna.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.hadith.HadithBookDownloadedEntity
import com.sonna.domain.entity.hadith.HadithBookNames
import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.ContentRepository
import com.sonna.local.ContentLocalDataSource
import com.sonna.mapper.toEntity
import com.sonna.mapper.toModel
import com.sonna.remote.ContentRemoteDataSource
import com.sonna.remote.response.hadith.HadithResponse
import retrofit2.Response


class ContentRepositoryImp(
    private val contentRemoteDataSource: ContentRemoteDataSource,
    private val contentLocalDataSource: ContentLocalDataSource
) : ContentRepository , BaseRepository() {
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

    override fun downloadFile(url: String, hadithBookName: String): Long {
        return contentRemoteDataSource.downloadFile(url, hadithBookName)

    }


    override suspend fun readSelectedHadithBook(): Pair<String,Int> {
        val readSelectedHadithBook = contentLocalDataSource.readSelectedHadithBookName()
        val hadithBook = HadithBookNames.fromName(readSelectedHadithBook)
        val numberOfHadithBook = hadithBook.numberOfHadithBook
        return Pair(readSelectedHadithBook,numberOfHadithBook)
    }


    override suspend fun saveSelectedHadithBook(hadithBook: String) {
        contentLocalDataSource.saveSelectedHadithBook(hadithBook)
    }

    override suspend fun getHadithBook(hadithName: HadithBookNames): List<HadithEntity> {
        val bookFetcherMap = mapOf<HadithBookNames, suspend () -> Response<HadithResponse>>(
            HadithBookNames.Darimi to contentRemoteDataSource::getDarimiHadithBook,
            HadithBookNames.Ahmed to contentRemoteDataSource::getAhmedBook,
            HadithBookNames.AbiDaud to contentRemoteDataSource::getAbiDaudBook,
            HadithBookNames.Bukhari to contentRemoteDataSource::getBukariBook,
            HadithBookNames.IbnMaja to contentRemoteDataSource::getIbnMajaBook,
            HadithBookNames.Malik to contentRemoteDataSource::getMalikBook,
            HadithBookNames.Muslim to contentRemoteDataSource::getMuslimBook,
            HadithBookNames.Nasai to contentRemoteDataSource::getNasaiBook,
            HadithBookNames.Trmizi to contentRemoteDataSource::getTrmiziBook,
        )

        return wrapResponse { bookFetcherMap[hadithName]!!.invoke() }.toEntity()
    }

    override suspend fun saveHadithBook(hadithBook: List<HadithEntity>): List<Long> {
        return contentLocalDataSource.saveHadithBook(hadithBook.toModel())
    }

    override suspend fun getSingleHadith(
        hadithBookName: String,
        numberOfHadith: Int
    ): HadithEntity {
        return contentLocalDataSource.getSingleHadith(hadithBookName, numberOfHadith).toEntity()
    }

    override suspend fun saveDownloadedHadithBookName(hadithBookDownloadedModel: HadithBookDownloadedEntity): Long {
        return contentLocalDataSource.saveDownloadedHadithBookName(hadithBookDownloadedModel.toEntity())
    }

    override suspend fun isHadithBookDownloaded(hadithBookName: HadithBookNames): Boolean {
        return contentLocalDataSource.isHadithBookDownloaded(hadithBookName)
    }
}