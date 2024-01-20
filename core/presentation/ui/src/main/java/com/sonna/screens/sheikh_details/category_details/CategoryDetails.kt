package com.sonna.screens.sheikh_details.category_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sonna.common.R
import com.sonna.common.composables.SonnaBottomSheet
import com.sonna.common.composables.SonnaScaffold
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.screens.sheikh_details.category_details.composables.HeaderCategoryDetails
import com.sonna.screens.sheikh_details.composables.ControlPanel
import com.sonna.screens.sheikh_details.composables.Voices

@Composable
fun CategoryDetailsScreen() {
    CategoryDetailsContent(CategoryDetailsState())
}

@Composable
fun CategoryDetailsContent(categoryDetailsState: CategoryDetailsState) {
    var stateBottomSheetVisibility by rememberSaveable { mutableStateOf(false) }
    SonnaScaffold(
        titleOfTopBar = categoryDetailsState.titleOfCategory,
        navigationBack = {},
    ) {paddingValues ->
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        HeaderCategoryDetails(
            categoryPic=categoryDetailsState.categoryPic,
            titleOfCategory=categoryDetailsState.titleOfCategory,
            numberOfTracks=categoryDetailsState.numberOfTracks,
            timeOfPublished = categoryDetailsState.timeOfPublished,
            nameOfSheikh=categoryDetailsState.nameOfSheikh,
            clickBack={})
        ControlPanel(
            hintAboutSheikh = categoryDetailsState.nameOfSheikh,
            clickFavorite = {},
            clickMore = {},
            clickRandom = {},
            clickPlay = {},
            hasHint = false
        )

        Voices(
            title = R.string.tracks,
            isList=true,
            voices = categoryDetailsState.voicesOfCategory, clickMore = {
                stateBottomSheetVisibility = true
            })

        SonnaBottomSheet(
            changeBottomSheetVisibility=stateBottomSheetVisibility,
            onDismissRequest={stateBottomSheetVisibility = false},
            bottomSheetItems=categoryDetailsState.itemsOfBottomSheet)
    }
}
}

@ThemePreviews
@Composable
fun CategoryDetailsPreview() {
    SonnaAppTheme {
        CategoryDetailsContent(CategoryDetailsState())

    }
}