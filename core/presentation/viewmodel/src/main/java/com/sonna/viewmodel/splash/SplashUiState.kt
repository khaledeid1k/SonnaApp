package com.sonna.viewmodel.splash

import com.sonna.common.bases.BaseErrorUiState
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.SurahEntity

data class SplashUiState(
    val azkar: List<ZekrEntity> = emptyList(),
    val isQuranLoading: Boolean = true,
    val isAzkarLoading: Boolean = true,
    val error: BaseErrorUiState? = null,
)