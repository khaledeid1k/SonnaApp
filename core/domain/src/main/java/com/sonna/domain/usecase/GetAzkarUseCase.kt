package com.sonna.domain.usecase

import com.sonna.domain.entity.azkar.AzkarCategoryEntity
import com.sonna.domain.repository.CoreRepository
import kotlinx.coroutines.flow.map

class GetAzkarUseCase(
    private val coreRepository: CoreRepository
) {
    suspend operator fun invoke(fromLocal: Boolean = false, category: String = "") =
        coreRepository.getAzkar(fromLocal, category)

    suspend fun getAzkarCategories(fromLocal: Boolean = false) = this(fromLocal).map {
        it.azkarList.groupingBy { zekr -> zekr.category }
            .eachCount()
            .map { (name, count) -> AzkarCategoryEntity(name, count) }
    }
}