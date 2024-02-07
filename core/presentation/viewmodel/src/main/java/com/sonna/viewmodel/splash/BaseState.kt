package com.sonna.viewmodel.splash

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.quran.QuranEntity


data class BaseState<T>(
    val data: T? = null,
    val error: String? = null,
    val loading: Boolean = true,
)
data class SplashState(
    val quranEntity: QuranEntity? = null,
    val azkarEntity: AzkarEntity? = null
)