package com.sonna.domain.usecase

import com.sonna.domain.repository.ContentRepository

class GetLastHadith (private val contentRepository: ContentRepository){
    suspend operator fun invoke() = contentRepository.getSLastHadith()

}