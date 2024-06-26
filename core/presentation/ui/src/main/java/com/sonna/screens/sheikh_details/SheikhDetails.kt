package com.sonna.screens.sheikh_details

import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sonna.common.composables.SonnaScaffold
import com.sonna.common.R
import com.sonna.common.composables.DividerLine
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.sheikh_details.composables.AboutSheikh
import com.sonna.screens.sheikh_details.composables.HeaderOfSheikhDetails
import com.sonna.screens.sheikh_details.composables.Voices
import com.sonna.screens.sheikh_details.composables.ControlPanel
import com.sonna.common.composables.SonnaBottomSheet

@Composable
fun SheikhDetailsScreen() {
    SheikhDetailsContent(SheikhDetailsState())
}


@Composable
fun SheikhDetailsContent(sheikhDetailsState: SheikhDetailsState) {
    var stateBottomSheetVisibility by rememberSaveable { mutableStateOf(false) }

    val rememberScrollState = rememberScrollState()
    SonnaScaffold(
        titleOfTopBar = sheikhDetailsState.nameOfSheikh,
        isAppBarExisting = true,
        isTopBarVisibleDuringScroll=true,
        navigationBack = {},
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState)
                .padding(paddingValues)
                .clickable {}
        ) {

            HeaderOfSheikhDetails(
                sheikhName = sheikhDetailsState.nameOfSheikh,
                sheikhPic = sheikhDetailsState.sheikhPic,
                scrollState = rememberScrollState,
                clickBack = {})

            ControlPanel(
                hintAboutSheikh = sheikhDetailsState.hintAboutSheikh,
                clickFavorite = {},
                clickMore = {},
                clickRandom = {},
                clickPlay = {},
            )

            Voices(
                title = stringResource(id = R.string.popular),
                voices = sheikhDetailsState.popularVoices, clickMore = {
                    stateBottomSheetVisibility = true
                })

            SonnaBottomSheet(
                changeBottomSheetVisibility = stateBottomSheetVisibility,
                onDismissRequest = { stateBottomSheetVisibility = false },
                bottomSheetItems = sheikhDetailsState.itemsOfBottomSheet
            )


            DividerLine(modifier = Modifier.padding(vertical = MaterialTheme.dimension.padding16))

            Voices(
                title =stringResource(id = R.string.categories),
                voices = sheikhDetailsState.categories)
            Text(
                text = stringResource(id = R.string.see_all),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .border(
                        MaterialTheme.dimension.thickness1,
                        MaterialTheme.colorScheme.primary,
                        CircleShape
                    )
                    .padding(
                        vertical = MaterialTheme.dimension.padding4,
                        horizontal = MaterialTheme.dimension.padding8
                    )
                    .clickable {

                    },
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )

            DividerLine(modifier = Modifier.padding(vertical = MaterialTheme.dimension.padding16))

            AboutSheikh(sheikhDetailsState.about)

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