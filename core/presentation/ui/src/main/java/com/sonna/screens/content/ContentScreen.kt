package com.sonna.screens.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.content.composables.ContentListCard
import com.sonna.screens.content.composables.LastReadCard
import com.sonna.viewmodel.content.ContentState
import com.sonna.viewmodel.content.ContentViewModel

@Composable
fun ContentScreen(
    mViewModel: ContentViewModel = hiltViewModel()
) {
    val state by mViewModel.state.collectAsState()
    ContentScreenContent(state, mViewModel::changeTab)
}

@Composable
fun ContentScreenContent(
    state: ContentState = ContentState(),
    onTapChange: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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
            if (state.selectedTabIndex==0){
            items(state.ahadith) { item ->
                ContentListCard(
                    surahIndex = item.number,
                    surahName = item.name,
                    surahEnglishName = item.englishName,
                    numOfVerses = item.numberOfAyahs
                )
            if (state.selectedTabIndex==0){
                items(count = state.surahesList.size) {
                    ContentListCard(
                        surahIndex = state.surahesList[it].number,
                        surahName = state.surahesList[it].name,
                        surahEnglishName = state.surahesList[it].englishName,
                        numOfVerses = state.surahesList[it].numberOfAyahs
                    )
                }
            }else if (state.selectedTabIndex==state.tabs.size-1){
                items(count = state.azkarList.size) {
                    ContentListCard(
                        surahIndex = it+1,
                        surahName = state.azkarList[it].name,
                        //surahEnglishName = state.surahesList[it].englishName,
                        numOfVerses = state.azkarList[it].numberOfAzkar
                    )
                }
            }
            }

        }


    }
}


@Preview(showBackground = true)
@Composable
fun PreviewContentScreen() {
    SonnaAppTheme {
        ContentScreenContent()
    }
}