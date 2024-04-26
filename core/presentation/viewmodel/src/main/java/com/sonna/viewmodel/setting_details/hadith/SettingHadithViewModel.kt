package com.sonna.viewmodel.setting_details.hadith

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonna.domain.entity.hadith.HadithBookNames
import com.sonna.domain.usecase.DownloadHadithBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingHadithViewModel @Inject constructor(private val downloadHadithBookUseCase: DownloadHadithBookUseCase) :
    ViewModel(), SettingHadithActions {
    private val _state: MutableStateFlow<HadithSettingState> =
        MutableStateFlow(HadithSettingState())
    val state = _state.asStateFlow()
    override fun downloadHadithBook(hadithBookName: String) {
        viewModelScope.launch {
            downloadHadithBookUseCase(HadithBookNames.fromName(hadithBookName))

        }
    }
}