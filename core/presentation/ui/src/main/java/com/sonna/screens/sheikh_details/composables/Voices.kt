package com.sonna.screens.sheikh_details.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sonna.common.composables.Title
import com.sonna.common.theme.dimension
import com.sonna.screens.sheikh_details.Category
import com.sonna.screens.sheikh_details.Voice

@Composable
fun <T> Voices(
    modifier: Modifier = Modifier,
    voices: List<T>, clickMore: () -> Unit = {},
    isList: Boolean = false,
    isTitleExisting: Boolean = true,
    title: String = "",
) {
    if (isTitleExisting) {
        Title(
            text =  title,
            modifier = Modifier.padding(start = MaterialTheme.dimension.padding16),
        )
    }

    if (!isList) {
        voices.forEach { voice ->
            when (voice) {
                is Voice -> {
                    VoicesItem(modifier = modifier, voice = voice) { clickMore() }
                }

                is Category -> {
                    CategoriesItem(modifier = modifier, category = voice)
                }
            }
        }


    } else {
        LazyColumn {
            items(voices) { voice ->
                when (voice) {
                    is Voice -> {
                        VoicesItem(modifier = modifier, voice = voice) { clickMore() }
                    }
                    is Category -> {
                        CategoriesItem(modifier = modifier, category = voice)
                    }
                }
            }
        }
    }


}