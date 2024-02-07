package com.sonna.viewmodel.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonna.common.utils.Resource
import com.sonna.common.utils.handleApiErrors
import com.sonna.common.utils.safeCall
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.GetQuranUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val getQuranUseCase: GetQuranUseCase,
    val getAzkarUseCase: GetAzkarUseCase,
) : ViewModel() {


    private val _splashState = MutableStateFlow(SplashState())
    private val splashState = _splashState.asStateFlow()

    private val _state = MutableStateFlow(
        BaseState(
            data = splashState.value
        )
    )
    val state = _state.asStateFlow()

    companion object {
        private const val TAG = "SplashViewModel"
    }

    init {
        getQuran()
        getAzkar()
    }

    private fun getQuran() {
        viewModelScope.launch {
            when (val result = safeCall { getQuranUseCase() }) {
                is Resource.Failure -> {
                    Log.e(TAG, "getQuran: ${result.errorCode} : ${result.errorBody}")
                    _state.update {
                        it.copy(
                            error = handleApiErrors(result),
                            loading = false
                        )
                    }
                }

                Resource.Loading -> {
                    Log.i(TAG, "getQuran: loading")
                    _state.update { it.copy(loading = true) }
                }

                is Resource.Success -> {
                    Log.i(TAG, "getQuran: ${result.value.surahes.size}")
                    _state.update {
                        it.copy(
                            loading = false,
                        )
                    }
                    _splashState.update { it.copy(quranEntity = result.value) }
                }
            }
        }
    }

    private fun getAzkar() {
        viewModelScope.launch {
            when (val result = safeCall { getAzkarUseCase() }) {
                is Resource.Failure -> {
                    Log.e(TAG, "getAzkar: ${result.errorCode} : ${result.errorBody}")
                    _state.update {
                        it.copy(
                            error = handleApiErrors(result),
                            loading = false
                        )
                    }
                }

                Resource.Loading -> {
                    Log.i(TAG, "getAzkar: loading")
                    _state.update { it.copy(loading = true) }
                }

                is Resource.Success -> {
                    Log.i(TAG, "getAzkar: ${result.value.azkarList.size}")
                    _state.update {
                        it.copy(
                            loading = false
                        )
                    }
                    _splashState.update { it.copy(azkarEntity = result.value) }
                }
            }
        }
    }
}