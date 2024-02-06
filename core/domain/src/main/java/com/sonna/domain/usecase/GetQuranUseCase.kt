package com.sonna.domain.usecase

import com.sonna.domain.repository.CoreRepository

class GetQuranUseCase(
    private val coreRepository: CoreRepository
) {
    suspend operator fun invoke() = coreRepository.getQuran()
}