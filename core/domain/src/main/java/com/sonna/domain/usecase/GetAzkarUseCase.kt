package com.sonna.domain.usecase

import com.sonna.domain.entity.azkar.AzkarCategoryEntity
import com.sonna.domain.repository.ContentRepository

class GetAzkarUseCase(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke(fromLocal:Boolean=false) = contentRepository.getAzkar(fromLocal)


    suspend fun getAzkarCategories(fromLocal:Boolean=false): List<AzkarCategoryEntity> =
        this(fromLocal).azkarList
            .groupingBy { it.category }
            .eachCount()
            .map { (name, count) -> AzkarCategoryEntity(name, count) }
}