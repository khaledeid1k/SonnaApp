package com.sonna.remote

class ContentRemoteDataSourceImp(
    private val contentApiServices: ContentApiServices
) : ContentRemoteDataSource {
    override suspend fun getSurahes() = contentApiServices.getSurahes()
}