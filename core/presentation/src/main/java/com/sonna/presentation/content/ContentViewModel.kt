package com.sonna.presentation.content

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonna.domain.usecase.InsertSurahUseCase
import com.sonna.domain.usecase.GetSurahesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    val getSurahesUseCase: GetSurahesUseCase,
    val insertSurahUseCase: InsertSurahUseCase
) : ViewModel() {
    companion object {
        private const val TAG = "ContentViewModel"
    }

    init {
        Log.d(TAG, "init is called: ")
        getSurahes()
    }

    private fun getSurahes() {
        viewModelScope.launch {
            try {
                val result = getSurahesUseCase()
                Log.d(TAG, "getSurahes: ${result.data}")
                insertSurahUseCase(result.data[0])
            } catch (e: Exception) {
                Log.e(TAG, "getSurahes: ${e.message}", e)
            }
        }
    }


}