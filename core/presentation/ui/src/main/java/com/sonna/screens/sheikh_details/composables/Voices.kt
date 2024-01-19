package com.sonna.screens.sheikh_details.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sonna.common.R
import com.sonna.common.composables.Title
import com.sonna.common.theme.dimension
import com.sonna.screens.sheikh_details.CategoryVoiceState
import com.sonna.screens.sheikh_details.PopularVoiceState

@Composable
fun <T>Voices(voices: List<T>, clickMore:()->Unit,@StringRes title:Int) {

    Title(
        text = stringResource(id = title),
        modifier = Modifier.padding(start = MaterialTheme.dimension.padding16),
    )

    voices.forEach { voice ->
        when(voice){
            is PopularVoiceState ->{ PopularVoicesItem(voice){ clickMore() }}
            is CategoryVoiceState ->{ CategoriesVoicesItem(voice)}
        }

    }


}