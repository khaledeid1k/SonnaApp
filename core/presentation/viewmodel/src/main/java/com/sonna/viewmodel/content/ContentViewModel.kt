package com.sonna.viewmodel.content

import androidx.lifecycle.SavedStateHandle
import com.sonna.common.bases.BaseErrorUiState
import com.sonna.common.bases.BaseViewModel
import com.sonna.common.routes.ContentArgs
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.GetQuranUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getQuranUseCase: GetQuranUseCase,
    val getAzkarUseCase: GetAzkarUseCase,
) : BaseViewModel<ContentUiState>(ContentUiState()) {
    companion object {
        private const val TAG = "ContentViewModel"
    }


    private val args = ContentArgs(savedStateHandle)

    init {
        changeTab(args.tabIndexArgs?.toInt() ?: 0)
        getSurahes()
    }


    private fun getSurahes() {
        tryToExecute(
            { getQuranUseCase(fromLocal = true) },
            ::onGetSurahesSuccess,
            ::onError
        )
    }

    private fun onGetSurahesSuccess(surahes: QuranEntity) {
        updateState { it.copy(surahesList = surahes.surahes.map { entity -> entity.toState() }) }
    }

    private fun onError(error: BaseErrorUiState) = updateState { it.copy(error = error) }

    private fun getAzkar() {}

    fun changeTab(tabIndex: Int) = updateState { it.copy(selectedTabIndex = tabIndex) }
}