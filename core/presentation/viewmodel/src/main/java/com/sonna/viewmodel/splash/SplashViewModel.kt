package com.sonna.viewmodel.splash

import android.util.Log
import com.sonna.common.bases.BaseErrorUiState
import com.sonna.common.bases.BaseViewModel
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.GetQuranUseCase
import com.sonna.domain.usecase.InsertSurahUseCase
import com.sonna.domain.usecase.InsertZekrUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val getQuranUseCase: GetQuranUseCase,
    val getAzkarUseCase: GetAzkarUseCase,
    val insertSurahUseCase: InsertSurahUseCase,
    val insertZekrUseCase: InsertZekrUseCase
) : BaseViewModel<SplashUiState>(SplashUiState()) {
    companion object {
        private const val TAG = "SplashViewModel"
    }

    private var numOfSurahes = 0
    private var numOfAzkar = 0

    init {
        getQuran()
        getAzkar()
    }

    private fun getQuran() {
        Log.d(TAG, "getQuran: ")
        tryToExecute(
            { getQuranUseCase(true) },
            ::onGetQuranFromLocalSuccess,
            ::onError
        )
    }

    private fun onGetQuranFromLocalSuccess(quranEntity: QuranEntity) {
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
        numOfSurahes = quranEntity.surahes.size
        quranEntity.surahes.forEach {
            insertSurah(it)
        }
    }

    private fun insertSurah(surahEntity: SurahEntity) {
        tryToExecute(
            { insertSurahUseCase(surahEntity) },
            onSuccess = ::onInsertQuranSuccess,
            onError = ::onError
        )
    }

    private fun onInsertQuranSuccess(flag: Long) {
        numOfSurahes--
        if (numOfSurahes == 0) {
            updateState { it.copy(isQuranLoading = false) }
        }
        Log.d(TAG, "insertSurah: $numOfSurahes")
    }

    private fun getAzkar() {
        tryToExecute(
            { getAzkarUseCase(true) },
            ::onGetAzkarFromLocalSuccess,
            ::onError
        )
    }

    private fun onGetAzkarFromLocalSuccess(azkarEntity: AzkarEntity) {
        if (azkarEntity.azkarList.isEmpty()) {
            Log.d(TAG, "onGetAzkarSuccess: local is empty")
            tryToExecute(
                { getAzkarUseCase(false) },
                onSuccess = ::onGetAzkarFromNetworkSuccess,
                onError = ::onError
            )
        } else {
            Log.d(TAG, "onGetAzkarSuccess: local is not empty")
            updateState {
                it.copy(
                    isAzkarLoading = false
                )
            }
        }
    }

    private fun onGetAzkarFromNetworkSuccess(azkarEntity: AzkarEntity) {
        numOfAzkar = azkarEntity.azkarList.size
        azkarEntity.azkarList.forEach {
            insertZekr(it)
        }
    }

    private fun insertZekr(zekrEntity: ZekrEntity) {
        tryToExecute(
            { insertZekrUseCase(zekrEntity) },
            onSuccess = ::onInsertAzkarSuccess,
            onError = ::onError
        )
    }

    private fun onInsertAzkarSuccess(flag: Long) {
        numOfAzkar--
        if (numOfAzkar == 0) {
            updateState { it.copy(isAzkarLoading = false) }
        }
        Log.d(TAG, "insertSurah: $numOfSurahes")
    }


    private fun onError(error: BaseErrorUiState) {
        Log.e(TAG, "onError: ${error.message}")
        updateState { it.copy(error = error, isQuranLoading = false, isAzkarLoading = false) }
    }
}