package com.sonna.domain.usecase

import com.sonna.domain.entity.azkar.AzkarCategoryEntity
import com.sonna.domain.repository.CoreRepository
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class GetAzkarUseCase(
    private val coreRepository: CoreRepository
) {
    suspend operator fun invoke(fromLocal: Boolean = false) = coreRepository.getAzkar(fromLocal)
    suspend fun getAzkarCategories(fromLocal: Boolean = false) = flow {
        this@GetAzkarUseCase(fromLocal).collect {
            emit(
                it.azkarList.groupingBy { it.category }
                    .eachCount()
                    .map { (name, count) -> AzkarCategoryEntity(name, count) }
            )
        }
    }
}