package com.sonna.viewmodel.details

import androidx.lifecycle.SavedStateHandle
import com.sonna.common.bases.BaseErrorUiState
import com.sonna.common.bases.BaseViewModel
import com.sonna.common.routes.DetailsArgs
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.GetSurahUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getSurahUseCase: GetSurahUseCase,
    val getAzkarUseCase: GetAzkarUseCase
) : BaseViewModel<DetailsUiState>(DetailsUiState()) {
    companion object {
        private const val TAG = "DetailsViewModel"
    }

    private val args = DetailsArgs(savedStateHandle)

    init {
        val tabIndex = (args.tabIndexArgs?.toInt() ?: 0)
        changeTabIndex(tabIndex)
        if (tabIndex == 0) {
            getSurah(args.itemIndexArgs?.toInt() ?: 0)
        } else if (tabIndex == 2) {
            getAzkar(args.itemTitle ?: "")
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

    private fun getAzkar(zekrCategory: String) {
        tryToExecute(
            { getAzkarUseCase(true, zekrCategory) },
            ::onGetAzkarSuccess,
            ::onError
        )
    }

    private fun onGetAzkarSuccess(azkarEntity: AzkarEntity) {
        updateState {
            it.copy(
                title = azkarEntity.azkarList[0].category,
                azkar = azkarEntity.azkarList.map { it.toState() },
            )
        }
    }

    private fun changeTabIndex(tabIndex:Int) = updateState { it.copy(tabIndex = tabIndex) }

    private fun onError(error: BaseErrorUiState) = updateState { it.copy(error = error) }

}