package com.sonna.repository

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.hadith.HadithBookDownloadedEntity
import com.sonna.local.model.HadithBookNames
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.ContentRepository
import com.sonna.local.ContentLocalDataSource
import com.sonna.mapper.toEntity
import com.sonna.mapper.toModel
import com.sonna.remote.ContentRemoteDataSource
import com.sonna.remote.response.hadith.HadithResponse
import kotlinx.coroutines.flow.Flow
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




    override suspend fun readSelectedHadithBook(): Pair<String,Int> {
        val readSelectedHadithBook = contentLocalDataSource.readSelectedHadithBookName()
        val hadithBook = HadithBookNames.fromName(readSelectedHadithBook)
        val numberOfHadithBook = hadithBook.numberOfHadithBook
        return Pair(readSelectedHadithBook,numberOfHadithBook)
    }


    override suspend fun saveSelectedHadithBook(hadithBook: String) {
        contentLocalDataSource.saveSelectedHadithBook(hadithBook)
    }

    override suspend fun getHadithBook(hadithName:String): Flow<List<HadithEntity> >{
        val bookFetcherMap = mapOf<String, suspend () -> Response<HadithResponse>>(
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
      ?.toEntity() ?: emptyList()

        return wrapResponse {   bookFetcherMap[hadithName]?.invoke() }
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

    override suspend fun isHadithBookDownloaded(hadithBookName: String): Boolean {
        return contentLocalDataSource.isHadithBookDownloaded(hadithBookName)
    }
}