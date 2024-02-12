package com.sonna.common.routes

import androidx.lifecycle.SavedStateHandle

class ContentArgs(savedStateHandle: SavedStateHandle) {
    val tabIndexArgs: String? = savedStateHandle[TAB_INDEX_ARGS]

    companion object {
        const val TAB_INDEX_ARGS = "TAB_INDEX_ARGS"
    }
}