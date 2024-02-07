package com.sonna.viewmodel.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonna.common.utils.Resource
import com.sonna.common.utils.safeCall
import com.sonna.domain.usecase.GetQuranUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val getQuranUseCase: GetQuranUseCase,
) : ViewModel() {
    companion object {
        private const val TAG = "SplashViewModel"
    }

    init {
        getQuran()
    }

    private fun getQuran() {
        viewModelScope.launch {
            when (val result = safeCall { getQuranUseCase() }) {
                is Resource.Failure -> {
                    Log.e(TAG, "getQuran: ${result.errorCode}")
                }

                Resource.Loading -> {
                    Log.i(TAG, "getQuran: loading")
                }

                is Resource.Success -> {
                    Log.i(TAG, "getQuran: ${result.value.surahes.size}")
                }
            }
            /*try {
                val result = getQuranUseCase()
                Log.d(TAG, "getQuran: ${result.surahes.size}")
            } catch (e: Exception) {
                Log.e(TAG, "getQuran: ${e.message}", e)
            }*/
        }
    }
}