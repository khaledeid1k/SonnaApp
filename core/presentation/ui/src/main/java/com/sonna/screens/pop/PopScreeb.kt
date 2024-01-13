package com.sonna.screens.pop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.dimension
import com.sonna.screens.home.composables.BottomOfPop
import com.sonna.screens.pop.composables.ContentOfPop
import com.sonna.screens.pop.composables.HeaderOfPop


@Composable
fun PopScreen() {
    PopContent(PopState())
}

@Composable
fun PopContent(popState: PopState) {
    Card(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .wrapContentSize()
            .padding(MaterialTheme.dimension.spacing16)
    ) {
        Column(modifier = Modifier.padding(MaterialTheme.dimension.spacing16)) {
            HeaderOfPop(
                play = {},
                done = {},
                share = {},
                close = {})

            ContentOfPop(
                style = MaterialTheme.typography.bodyMedium,
                text = popState.quran)

            BottomOfPop(
                nameOfSura = popState.nameOfSura,
                numberOfAya = popState.numberOfAya,
                next = {},
                previous = {},
                favorite = {})

            ContentOfPop(
                style = MaterialTheme.typography.bodySmall,
                text = popState.tafser)

        }
    }
}

@ThemePreviews
@Composable
fun PopPreview() {
    PopContent(PopState())

}

