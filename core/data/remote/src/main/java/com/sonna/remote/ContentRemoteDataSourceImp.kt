package com.sonna.remote

class ContentRemoteDataSourceImp(
    private val contentApiServicesQuran: ContentApiServicesQuran,
    private val contentApiServicesAzkarAndHadith: ContentApiServicesAzkarAndHadith
) : ContentRemoteDataSource {
    override suspend fun getDarimiBook() =contentApiServicesAzkarAndHadith.getDarimiBook()
    override suspend fun getSurahes() = contentApiServicesQuran.getSurahes()
    override suspend fun getAzkar() = contentApiServicesAzkarAndHadith.getAzkar()
}