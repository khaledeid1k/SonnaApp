package com.sonna.remote

class CoreRemoteDataSourceImp(
    private val coreApiServicesQuran: CoreApiServicesQuran,
    private val coreApiServicesAzkar: CoreApiServicesAzkar
) : CoreRemoteDataSource {
    override suspend fun getQuran() = coreApiServicesQuran.getQuran()
    override suspend fun getAzkar() = coreApiServicesAzkar.getAzkar()
}