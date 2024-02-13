package com.sonna.viewmodel.splash

import android.util.Log
import com.sonna.common.bases.BaseErrorUiState
import com.sonna.common.bases.BaseViewModel
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.GetQuranUseCase
import com.sonna.domain.usecase.InsertSurahUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val getQuranUseCase: GetQuranUseCase,
    val getAzkarUseCase: GetAzkarUseCase,
    val insertSurahUseCase: InsertSurahUseCase
) : BaseViewModel<SplashUiState>(SplashUiState()) {
    companion object {
        private const val TAG = "SplashViewModel"
    }

    private var numOfSurahes = 0

    init {
        getQuran()
        getAzkar()
    }

    private fun getQuran() {
        Log.d(TAG, "getQuran: ")
        tryToExecute(
            { getQuranUseCase(true) },
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

    private fun insertSurah(surahEntity: SurahEntity) {
        tryToExecute(
            { insertSurahUseCase(surahEntity) },
            onSuccess = ::onInsertSuccess,
            onError = ::onError
        )
    }

    private fun onInsertSuccess(flag: Long) {
        numOfSurahes++
        if (numOfSurahes == 114) {
            updateState { it.copy(isQuranLoading = false) }
        }
        Log.d(TAG, "insertSurah: $numOfSurahes")
    }

    private fun onGetQuranSuccess(quranEntity: QuranEntity) {
        if (quranEntity.surahes.isEmpty()) {
            Log.d(TAG, "onGetQuranSuccess: local is empty")
            tryToExecute(
                { getQuranUseCase(false) },
                onSuccess = ::onGetQuranFromNetworkSuccess,
                onError = ::onError
            )
        } else {
            Log.d(TAG, "onGetQuranSuccess: local is not empty")
            updateState {
                it.copy(
                    isQuranLoading = false
                )
            }
        }
    }

    private fun onGetQuranFromNetworkSuccess(quranEntity: QuranEntity) {
        quranEntity.surahes.forEach {
            insertSurah(it)
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
        Log.e(TAG, "onError: ${error.message}")
        updateState { it.copy(error = error, isQuranLoading = false, isAzkarLoading = false) }
    }
}