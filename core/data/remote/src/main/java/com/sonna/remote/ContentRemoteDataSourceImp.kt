package com.sonna.remote

import com.sonna.remote.download_manger.DownloaderFile
import com.sonna.remote.response.hadith.HadithResponse
import retrofit2.Response

class ContentRemoteDataSourceImp(
    private val contentApiServicesQuran: ContentApiServicesQuran,
    private val contentApiServicesAzkarAndHadith: ContentApiServicesAzkarAndHadith,
    private val downloaderFile: DownloaderFile,
) : ContentRemoteDataSource {
    override suspend fun getDarimiHadithBook():  Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getDarimiBook()
    }

    override suspend fun getAhmedBook():  Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getAhmedBook()
    }

    override suspend fun getAbiDaudBook(): Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getAbiDaudBook()
    }

    override suspend fun getBukariBook():  Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getBukariBook()
    }

    override suspend fun getIbnMajaBook():  Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getIbnMajaBook()
    }

    override suspend fun getMalikBook():  Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getMalikBook()
    }

    override suspend fun getMuslimBook():  Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getMuslimBook()
    }

    override suspend fun getNasaiBook():  Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getNasaiBook()
    }

    override suspend fun getTrmiziBook():  Response<HadithResponse> {
        return contentApiServicesAzkarAndHadith.getTrmiziBook()
    }

    override fun downloadFile(url: String, hadithBookName: String): Long {
        return downloaderFile.downloadFile(url, hadithBookName)
    }

    override suspend fun getSurahes() = contentApiServicesQuran.getSurahes()
    override suspend fun getAzkar() = contentApiServicesAzkarAndHadith.getAzkar()
}