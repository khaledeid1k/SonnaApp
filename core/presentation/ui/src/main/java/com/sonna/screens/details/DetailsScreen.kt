package com.sonna.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.details.composables.DetailsHeader
import com.sonna.screens.details.composables.VerseItem
import com.sonna.viewmodel.details.DetailsUiState
import com.sonna.viewmodel.details.DetailsViewModel

@Composable
fun DetailsScreen(
    navController: NavController,
    mViewModel: DetailsViewModel = hiltViewModel()
) {
    val state by mViewModel.state.collectAsState()
    DetailsContent(state)
}

@Composable
fun DetailsContent(
    state: DetailsUiState = DetailsUiState()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        DetailsHeader(surahName = state.title)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(MaterialTheme.dimension.padding24),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding16)
        ) {
            items(state.ayahs.size) {
                VerseItem(
                    arabicVerse = state.ayahs[it].text,
                    englishVerse = "[All] praise is [due] to Allah, Lord of the worlds –"
                )
            }
        }
    }
}

@ThemePreviews
@Composable
fun DetailsPreview() {
    SonnaAppTheme {
        DetailsContent()
    }
}