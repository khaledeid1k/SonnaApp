package com.sonna.presentation.details.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun DetailsHeader(
    modifier: Modifier = Modifier,
    surahName: String,
    showBasmala: Boolean = true,
) {
    Box(
        modifier = modifier.wrapContentHeight()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.dimension.height126),
            painter = painterResource(id = R.drawable.header_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.dimension.height126)
                .padding(horizontal = MaterialTheme.dimension.padding24),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = null,
                tint = Color.White,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = surahName,
                    style = MaterialTheme.typography.bodyMedium

                    )
                if (showBasmala) {
                    Text(
                        text = "بسم الله الرحمن الرحيم",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Icon(
                Icons.Rounded.MoreVert,
                contentDescription = null,
                tint = Color.White,
            )
        }
    }
}

@Preview()
@Composable
fun DetailsHeaderPreview() {
    DetailsHeader(surahName = "hello")
}