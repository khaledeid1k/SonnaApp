package com.sonna.domain.usecase

import com.sonna.domain.repository.ContentRepository

class GetAzkarUseCase(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke() = contentRepository.getAzkar()

    /*suspend fun getAzkarCategory(): List<String> {
        val categories = mutableListOf<String>()
        contentRepository.getAzkar().forEach {
            categories.add(it.category)
        }
        return categories.toList()
    }*/

    suspend fun getAzkarCategories(): List<String> = contentRepository.getAzkar().distinctBy { it.category }.map { it.category }
}