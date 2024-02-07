package com.sonna.remote

import kotlinx.coroutines.flow.flow

class CoreRemoteDataSourceImp(
    private val coreApiServicesQuran: CoreApiServicesQuran,
    private val coreApiServicesAzkar: CoreApiServicesAzkar
) : CoreRemoteDataSource {
    override suspend fun getQuran() = flow { emit(coreApiServicesQuran.getQuran()) }
    override suspend fun getAzkar() = flow { emit(coreApiServicesAzkar.getAzkar()) }
}