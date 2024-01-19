package com.sonna.screens.sheikh_details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sonna.common.composables.SonnaScaffold
import com.sonna.common.R
import com.sonna.common.composables.DividerLine
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.sheikh_details.composables.AboutSheikh
import com.sonna.screens.sheikh_details.composables.HeaderOfSheikhDetails
import com.sonna.screens.sheikh_details.composables.Voices
import com.sonna.screens.sheikh_details.composables.SheikhControlPanel
import com.sonna.common.composables.SonnaBottomSheet

@Composable
fun SheikhDetailsScreen() {
    SheikhDetailsContent(SheikhDetailsState())
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheikhDetailsContent(sheikhDetailsState: SheikhDetailsState) {
    var stateBottomSheetVisibility by rememberSaveable { mutableStateOf(false) }

    SonnaScaffold(
        titleOfTopBar = sheikhDetailsState.nameOfSheikh,
        navigationBack = {},
    ) { paddingValues, scrollState ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(paddingValues)
                .clickable {}
        ) {

            HeaderOfSheikhDetails(
                sheikhName = sheikhDetailsState.nameOfSheikh,
                sheikhPic = sheikhDetailsState.sheikhPic,
                scrollState = scrollState, clickBack = {})

            SheikhControlPanel(
                hintAboutSheikh = sheikhDetailsState.hintAboutSheikh,
                clickFavorite = {},
                clickMore = {},
                clickRandom = {},
                clickPlay = {},
            )

            Voices(
                title = R.string.popular,
                voices = sheikhDetailsState.popularVoices, clickMore = {
                    stateBottomSheetVisibility = true
                })







            SonnaBottomSheet(
                changeBottomSheetVisibility=stateBottomSheetVisibility,
                onDismissRequest={stateBottomSheetVisibility = false},
                bottomSheetItems=sheikhDetailsState.itemsOfBottomSheet)


            DividerLine(modifier = Modifier.padding(vertical = MaterialTheme.dimension.padding16))

            Voices(
                title = R.string.categories,
                voices = sheikhDetailsState.categoryVoices, clickMore = {})
            DividerLine(modifier = Modifier.padding(vertical = MaterialTheme.dimension.padding16))

            AboutSheikh(sheikhDetailsState.aboutState)

        }

    }

}

@ThemePreviews
@Composable
fun SheikhDetailsPreview() {
    SonnaAppTheme {
        SheikhDetailsContent(SheikhDetailsState())
    }
}