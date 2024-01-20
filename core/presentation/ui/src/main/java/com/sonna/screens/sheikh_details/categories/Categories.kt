package com.sonna.screens.sheikh_details.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sonna.common.R
import com.sonna.common.composables.SonnaScaffold
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.screens.sheikh_details.composables.Voices

@Composable
fun CategoriesScreen() {
    CategoriesContent(CategoriesState())
}

@Composable
fun CategoriesContent(categoriesState: CategoriesState) {
    SonnaScaffold(
        titleOfTopBar = stringResource(id = R.string.categories),
        isAppBarExisting = true,
        isTopBarVisibleDuringScroll=false,
        navigationBack = {}
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Voices(
                modifier = Modifier
                    .fillMaxWidth(),
                isTitleExisting=false,
                voices = categoriesState.categories, isList = true
            )
        }
    }
}

@ThemePreviews
@Composable
fun CategoriesPreviews() {
    SonnaAppTheme {
        CategoriesContent(CategoriesState())
    }
}