package com.sonna.domain.usecase

import com.sonna.domain.repository.CoreRepository
import kotlinx.coroutines.flow.map

class GetSurahUseCase(
    private val coreRepository: CoreRepository
) {
    suspend operator fun invoke(surahIndex: Int) =
        coreRepository.getSurah(surahIndex).map { surahEntity ->
            val modifiedAyahs = surahEntity.ayahs.toMutableList()
            if (surahEntity.number == 1) {
                modifiedAyahs.removeAt(0)
            } else {
                modifiedAyahs[0].text = modifiedAyahs[0].text.replace("بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ", "")
            }
            surahEntity.copy(ayahs = modifiedAyahs)
        }
}