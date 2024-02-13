package com.sonna.viewmodel.setting

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class SettingViewModel: ViewModel(){
    val _state:MutableStateFlow<SettingState> = MutableStateFlow(SettingState())
    val state= _state.asStateFlow()

    fun asdad(){

    }
}