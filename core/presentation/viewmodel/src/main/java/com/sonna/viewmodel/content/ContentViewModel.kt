package com.sonna.viewmodel.content

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonna.common.routes.ContentArgs
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.InsertSurahUseCase
import com.sonna.domain.usecase.GetQuranUseCase
import com.sonna.domain.usecase.InsertZekrUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getQuranUseCase: GetQuranUseCase,
    val getAzkarUseCase: GetAzkarUseCase,
    val insertZekrUseCase: InsertZekrUseCase,
    val insertSurahUseCase: InsertSurahUseCase,
) : ViewModel() {
    companion object {
        private const val TAG = "ContentViewModel"
    }

    private val _state = MutableStateFlow(ContentState())
    val state = _state.asStateFlow()
    private val args = ContentArgs(savedStateHandle)

    init {
        changeTab(args.tabIndexArgs?.toInt() ?: 0)
        getAzkar()
        storeAzkar()
    }


    /*private fun getSurahes() {
        viewModelScope.launch {
            try {
                val result = getQuranUseCase().data.map { it.toState() }
                _state.update { it.copy(surahesList = result) }
                Log.d(TAG, "getSurahes: $result")
                //insertSurahUseCase(result.data[0])
            } catch (e: Exception) {
                Log.e(TAG, "getSurahes: ${e.message}", e)
            }
        }
    }*/

    private fun getAzkar() {
        viewModelScope.launch {
            try {
                /*var result = getAzkarUseCase.getAzkarCategories(true).map { it.toState() }
                if (result.isEmpty()) {
                    result = getAzkarUseCase.getAzkarCategories().map { it.toState() }
                }
                _state.update { it.copy(azkarList = result) }
                Log.d(TAG, "getAzkar: $result")*/
            } catch (e: Exception) {
                Log.e(TAG, "getAzkar: ${e.message}", e)
            }
        }
    }

    private fun storeAzkar() {
        viewModelScope.launch {
            try {
                var result = getAzkarUseCase(true)
                /*if (result.azkarList.isEmpty()) {
                    result = getAzkarUseCase()
                    result.azkarList.forEach {
                        insertZekrUseCase(it)
                    }
                    Log.d(TAG, "storeAzkar: $result")
                }else{
                    Log.d(TAG, "notStoreAzkar: $result")
                }*/
            } catch (e: Exception) {
                Log.e(TAG, "storeAzkar: ${e.message}", e)
            }
        }
    }

    fun changeTab(tabIndex: Int) {
        viewModelScope.launch {
            _state.update { it.copy(selectedTabIndex = tabIndex) }
        }
    }


}