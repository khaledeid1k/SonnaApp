package com.sonna.screens.content.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.sonna.common.theme.dimension
import com.sonna.viewmodel.content.ContentState

@Composable
fun AddDataAccordingSelectedTap(state: ContentState){
    LazyColumn(
        contentPadding = PaddingValues(vertical = MaterialTheme.dimension.padding16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding8)
    ) {
        when (state.selectedTabIndex){
            Taps.QURAN.index ->{
                items(state.surahesList) { surah ->
                    ContentListCard(
                        surahIndex = surah.number,
                        surahName = surah.name,
                        surahEnglishName = surah.englishName,
                        numOfVerses = surah.numberOfAyahs
                    )
                }
            }
            Taps.HADITH.index -> {
                items(state.ahadith) {hadith->
                    ContentListCard(
                        surahIndex = hadith.number,
                        surahName = hadith.name,
                        numOfVerses = hadith.number
                    )
                }
            }
            Taps.AZKAR.index -> {
                items(count = state.azkarList.size) {
                    ContentListCard(
                        surahIndex = it + 1,
                        surahName = state.azkarList[it].name,
                        numOfVerses = state.azkarList[it].numberOfAzkar
                    )
                }
            }
        }







    }

}

enum class Taps(val index: Int) {
    QURAN(0),HADITH(1),AZKAR(2)
}