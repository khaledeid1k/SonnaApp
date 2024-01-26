package com.sonna.remote

import com.sonna.remote.response.hadith.HadithResponse

class ContentRemoteDataSourceImp(
    private val contentApiServicesQuran: ContentApiServicesQuran,
    private val contentApiServicesAzkarAndHadith: ContentApiServicesAzkarAndHadith
) : ContentRemoteDataSource {
    override suspend fun getDarimiHadithBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getDarimiBook()
    }

    override suspend fun getAhmedBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getAhmedBook()
    }

    override suspend fun getAbiDaudBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getAbiDaudBook()
    }

    override suspend fun getBukariBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getBukariBook()
    }

    override suspend fun getIbnMajaBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getIbnMajaBook()
    }

    override suspend fun getMalikBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getMalikBook()
    }

    override suspend fun getMuslimBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getMuslimBook()
    }

    override suspend fun getNasaiBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getNasaiBook()
    }

    override suspend fun getTrmiziBook(): HadithResponse {
        return contentApiServicesAzkarAndHadith.getTrmiziBook()
    }

    override suspend fun getSurahes() = contentApiServicesQuran.getSurahes()
    override suspend fun getAzkar() = contentApiServicesAzkarAndHadith.getAzkar()
}