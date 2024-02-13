package com.sonna.screens.content.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sonna.common.theme.dimension

@Composable
fun ContentListCard(
    tabIndex: Int = 0,
    surahIndex: Int = 0,
    surahName: String = "",
    surahEnglishName: String = "",
    numOfVerses: Int = 0,
    onClick: (tabIndex:Int,itemIndex:Int) -> Unit = {_,_->}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.dimension.padding8,
                vertical = MaterialTheme.dimension.padding4
            )
            .clickable { onClick(tabIndex,surahIndex) },
        verticalAlignment = Alignment.CenterVertically
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
            Text(text = "$surahEnglishName ($numOfVerses)", color = Color.LightGray)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Rounded.Star,
            tint = MaterialTheme.colorScheme.primaryContainer,
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContentListCardPreview() {
    ContentListCard()
}