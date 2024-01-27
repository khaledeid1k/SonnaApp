package com.sonna.screens.content.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension

@Composable
fun ContentListCard(
    numberOfContent: Int = 0,
    name: String = "",
    englishName: String = "",
    hintOfContent: String = ""
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.dimension.padding8,
                vertical = MaterialTheme.dimension.padding4
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .height(MaterialTheme.dimension.height50)
                .width(MaterialTheme.dimension.width50),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer, //Card background color
            )
            ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = numberOfContent.toString())
            }
        }
        Column(
            modifier = Modifier
                .padding(start =MaterialTheme.dimension.padding16 )
                .height(MaterialTheme.dimension.height50)
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = name, style = MaterialTheme.typography.titleMedium)
            Text(

                text = "$englishName ($hintOfContent)",
                color = Color.LightGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
                )
        }
        Icon(
            imageVector = Icons.Rounded.Star,
            tint = MaterialTheme.colorScheme.primaryContainer,
            contentDescription = ""
        )
    }
}

@ThemePreviews
@Composable
fun ContentListCardPreview() {
    SonnaAppTheme {
        ContentListCard()
    }
}