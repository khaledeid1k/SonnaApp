package com.sonna.viewmodel.splash

import com.sonna.common.bases.BaseErrorUiState
import com.sonna.common.bases.BaseViewModel
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.GetQuranUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val getQuranUseCase: GetQuranUseCase,
    val getAzkarUseCase: GetAzkarUseCase,
) : BaseViewModel<SplashUiState>(SplashUiState()) {
    companion object {
        private const val TAG = "SplashViewModel"
    }

    init {
        getQuran()
        getAzkar()
    }

    private fun getQuran() {
        tryToExecute(
            { getQuranUseCase() },
            ::onGetQuranSuccess,
            ::onError
        )
    }

    private fun getAzkar() {
        tryToExecute(
            { getAzkarUseCase() },
            ::onGetAzkarSuccess,
            ::onError
        )
    }

    private fun onGetQuranSuccess(quranEntity: QuranEntity) {
        updateState {
            it.copy(
                surahes = quranEntity.surahes,
                isQuranLoading = false,
            )
        }
    }

    private fun onGetAzkarSuccess(azkarEntity: AzkarEntity) {
        updateState {
            it.copy(
                azkar = azkarEntity.azkarList,
                isAzkarLoading = false,
            )
        }
    }

    private fun onError(error: BaseErrorUiState) {
        updateState { it.copy(error = error, isQuranLoading = false, isAzkarLoading = false) }
    }
}