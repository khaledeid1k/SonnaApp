package com.sonna.viewmodel.details

import androidx.lifecycle.SavedStateHandle
import com.sonna.common.bases.BaseErrorUiState
import com.sonna.common.bases.BaseViewModel
import com.sonna.common.routes.DetailsArgs
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.usecase.GetSurahUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getSurahUseCase: GetSurahUseCase
) : BaseViewModel<DetailsUiState>(DetailsUiState()) {
    companion object {
        private const val TAG = "DetailsViewModel"
    }

    private val args = DetailsArgs(savedStateHandle)

    init {
        if ((args.tabIndexArgs?.toInt() ?: 0) == 0) {
            getSurah(args.itemIndexArgs?.toInt() ?: 0)
        }
    }


    private fun getSurah(surahIndex: Int) {
        tryToExecute(
            { getSurahUseCase(surahIndex) },
            ::onGetSurahSuccess,
            ::onError
        )
    }

    private fun onGetSurahSuccess(surah: SurahEntity) {
        updateState {
            it.copy(
                title = surah.name,
                ayahs = surah.ayahs.map { entity -> entity.toState() },
            )
        }
    }


    private fun onError(error: BaseErrorUiState) = updateState { it.copy(error = error) }

}