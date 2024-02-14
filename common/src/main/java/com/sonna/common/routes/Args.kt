package com.sonna.common.routes

import androidx.lifecycle.SavedStateHandle

class ContentArgs(savedStateHandle: SavedStateHandle) {
    val tabIndexArgs: String? = savedStateHandle[TAB_INDEX_ARGS]

    companion object {
        const val TAB_INDEX_ARGS = "TAB_INDEX_ARGS"
    }
}

class DetailsArgs(savedStateHandle: SavedStateHandle) {
    val tabIndexArgs: String? = savedStateHandle[TAB_INDEX_ARGS]
    val itemIndexArgs: String? = savedStateHandle[ITEM_INDEX_ARGS]
    val itemTitle: String? = savedStateHandle[ITEM_TITLE]

    companion object {
        const val TAB_INDEX_ARGS = "TAB_INDEX_ARGS"
        const val ITEM_INDEX_ARGS = "ITEM_INDEX_ARGS"
        const val ITEM_TITLE = "ITEM_TITLE"
    }
}