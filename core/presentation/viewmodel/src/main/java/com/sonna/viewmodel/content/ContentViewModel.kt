package com.sonna.viewmodel.content

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.InsertSurahUseCase
import com.sonna.domain.usecase.GetSurahesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    val getSurahesUseCase: GetSurahesUseCase,
    val getAzkarUseCase: GetAzkarUseCase,
    val insertSurahUseCase: InsertSurahUseCase
) : ViewModel() {
    companion object {
        private const val TAG = "ContentViewModel"
    }

    init {
        Log.d(TAG, "init is called: ")
        getSurahes()
        getAzkar()
    }

    private val _state = MutableStateFlow(ContentState())
    val state = _state.asStateFlow()

    private fun getSurahes() {
        viewModelScope.launch {
            try {
                val result = getSurahesUseCase().data.map { it.toState() }
                _state.update { it.copy(surahesList = result) }
                Log.d(TAG, "getSurahes: $result")
                //insertSurahUseCase(result.data[0])
            } catch (e: Exception) {
                Log.e(TAG, "getSurahes: ${e.message}", e)
            }
        }
    }

    private fun getAzkar() {
        viewModelScope.launch {
            try {
                val result = getAzkarUseCase.getAzkarCategories().map { it.toState() }
                _state.update { it.copy(azkarList = result) }
                Log.d(TAG, "getAzkar: $result")
            } catch (e: Exception) {
                Log.e(TAG, "getAzkar: ${e.message}", e)
            }
        }
    }

    fun changeTab(tabIndex: Int) {
        viewModelScope.launch {
            _state.update { it.copy(selectedTabIndex = tabIndex) }
        }
    }


}