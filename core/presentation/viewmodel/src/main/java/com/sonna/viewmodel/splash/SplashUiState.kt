package com.sonna.viewmodel.splash

import com.sonna.common.bases.BaseErrorUiState
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.entity.quran.SurahEntity

data class SplashUiState(
    val surahes: List<SurahEntity> = emptyList(),
    val azkar: List<ZekrEntity> = emptyList(),
    val isLoading: Boolean = true,
    val isSavedJob: Boolean = false,
    val error: BaseErrorUiState? = null,
)