package com.sonna.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.common.theme.dimension
import com.sonna.screens.details.composables.DetailsHeader
import com.sonna.screens.details.composables.VerseItem
import com.sonna.viewmodel.details.DetailsViewModel

@Composable
fun DetailsScreen(
    mViewModel:DetailsViewModel = hiltViewModel()
){
    DetailsContent()
}

@Composable
fun DetailsContent(){
    Column (
        modifier = Modifier.fillMaxSize(),
    ){
        DetailsHeader(surahName = "الفاتحة")
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(MaterialTheme.dimension.padding24),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding16)
        ){
            items(7){
                VerseItem(
                    arabicVerse = "الحمد لله رب العالمين",
                    englishVerse = "[All] praise is [due] to Allah, Lord of the worlds –"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview(){
    DetailsScreen()
}