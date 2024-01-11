package com.sonna.presentation.home

import androidx.lifecycle.ViewModel
import com.sonna.domain.usecase.GetLastHadith
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   val getLastHadith: GetLastHadith

) : ViewModel() {
}