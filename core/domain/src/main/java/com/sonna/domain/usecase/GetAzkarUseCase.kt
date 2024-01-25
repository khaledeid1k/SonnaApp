package com.sonna.domain.usecase

import com.sonna.domain.entity.azkar.AzkarCategoryEntity
import com.sonna.domain.repository.ContentRepository

class GetAzkarUseCase(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke() = contentRepository.getAzkar()


    suspend fun getAzkarCategories(): List<AzkarCategoryEntity> =
        contentRepository.getAzkar().azkarList
            .groupingBy { it.category }
            .eachCount()
            .map { (name, count) -> AzkarCategoryEntity(name, count) }
}