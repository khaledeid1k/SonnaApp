package com.sonna.viewmodel.details

import com.sonna.common.bases.BaseErrorUiState

data class DetailsUiState(
    val tabIndex: Int = 0,
    val title: String = "",
    val ayahs: List<AyaState> = emptyList(),
    val azkar: List<ZekrState> = emptyList(),
    val error: BaseErrorUiState? = null,
)

data class AyaState(
    val index: Int = 0,
    val text: String = "",
    val sajda: Boolean = false
)

data class ZekrState(
    val text: String = "",
    val count: String = ""
)