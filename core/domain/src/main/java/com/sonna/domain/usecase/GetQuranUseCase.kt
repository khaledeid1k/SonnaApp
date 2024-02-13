package com.sonna.domain.usecase

import com.sonna.domain.repository.CoreRepository

class GetQuranUseCase(
    private val coreRepository: CoreRepository
) {
    suspend operator fun invoke(fromLocal: Boolean = false) = coreRepository.getQuran(fromLocal)
}