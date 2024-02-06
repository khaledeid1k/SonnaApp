package com.sonna.viewmodel.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
            try {
                val result = getQuranUseCase()
                Log.d(TAG, "getQuran: ${result.surahes.size}")
            } catch (e: Exception) {
                Log.e(TAG, "getQuran: ${e.message}", e)
            }
        }
    }
}