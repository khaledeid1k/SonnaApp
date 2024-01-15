package com.sonna.screens.content.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sonna.common.theme.dimension

@Composable
fun ContentListCard(
    surahIndex: Int,
    surahName: String,
    surahEnglishName: String,
    numOfVerses: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.dimension.padding8,
                vertical = MaterialTheme.dimension.padding4
            )
    ) {
        Card(
            modifier = Modifier
                .height(MaterialTheme.dimension.height50)
                .width(MaterialTheme.dimension.width50),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = surahIndex.toString())
            }
        }
        Spacer(modifier = Modifier.width(MaterialTheme.dimension.width19))
        Column(
            modifier = Modifier.height(MaterialTheme.dimension.height50),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = surahName)
            Text(text = "$surahEnglishName $numOfVerses", color = Color.LightGray)
        }
    }
}