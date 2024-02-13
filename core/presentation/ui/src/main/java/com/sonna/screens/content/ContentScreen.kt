package com.sonna.screens.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.content.composables.ContentListCard
import com.sonna.screens.content.composables.LastReadCard
import com.sonna.screens.details.navigateToDetails
import com.sonna.viewmodel.content.ContentUiState
import com.sonna.viewmodel.content.ContentViewModel

@Composable
fun ContentScreen(
    navController: NavController,
    mViewModel: ContentViewModel = hiltViewModel()
) {
    val state by mViewModel.state.collectAsState()
    ContentScreenContent(state, mViewModel::changeTab) { tabIndex, itemIndex ->
        navController.navigateToDetails(tabIndex, itemIndex)
    }
}

@Composable
fun ContentScreenContent(
    state: ContentUiState = ContentUiState(),
    onTapChange: (Int) -> Unit = {},
    onItemClick: (tabIndex: Int, itemIndex: Int) -> Unit = { _, _ -> }
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
        //.padding(horizontal = MaterialTheme.dimension.padding24)
    ) {
        LastReadCard(surahName = "الفاتحة", verseNum = 5)
        TabRow(selectedTabIndex = state.selectedTabIndex) {
            for (i in 0..<state.tabs.size) {
                Tab(
                    text = { Text(state.tabs[i]) },
                    selected = i == state.selectedTabIndex,
                    onClick = { onTapChange(i) },
                )
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(vertical = MaterialTheme.dimension.padding16),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding8)
        ) {
            if (state.selectedTabIndex == 0) {
                items(count = state.surahesList.size) {
                    ContentListCard(
                        tabIndex = 0,
                        surahIndex = state.surahesList[it].number,
                        surahName = state.surahesList[it].name,
                        surahEnglishName = state.surahesList[it].englishName,
                        numOfVerses = state.surahesList[it].numberOfAyahs,
                        onClick = onItemClick
                    )
                }
            } else if (state.selectedTabIndex == state.tabs.size - 1) {
                items(count = state.azkarList.size) {
                    ContentListCard(
                        tabIndex = state.selectedTabIndex,
                        surahIndex = it + 1,
                        surahName = state.azkarList[it].name,
                        numOfVerses = state.azkarList[it].numberOfAzkar
                    )
                }
            }

        }


    }
}


@ThemePreviews
@Composable
fun PreviewContentScreen() {
    SonnaAppTheme {
        ContentScreenContent()
    }
}