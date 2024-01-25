package com.sonna.remote

class ContentRemoteDataSourceImp(
    private val contentApiServicesQuran: ContentApiServicesQuran,
    private val contentApiServicesAzkar: ContentApiServicesAzkar
) : ContentRemoteDataSource {
    override suspend fun getSurahes() = contentApiServicesQuran.getSurahes()
    override suspend fun getAzkar() = contentApiServicesAzkar.getAzkar()
}