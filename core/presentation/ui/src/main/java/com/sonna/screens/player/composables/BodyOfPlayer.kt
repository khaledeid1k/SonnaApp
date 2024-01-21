package com.sonna.screens.player.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.sonna.common.composables.SpacerVertical
import com.sonna.common.theme.dimension

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BodOfPlayer(
    modifier: Modifier=Modifier,
    imageOfTrack: Int,
    nameOfTrack: String,
    nameOfSheikh: String,
    clickFavorite:()->Unit
    ) {
    Column(modifier = modifier
        .padding(MaterialTheme.dimension.padding16)

    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(MaterialTheme.dimension.radius16)
                   ) .weight(1f),
            contentScale = ContentScale.Crop,

            painter = painterResource(id = imageOfTrack), contentDescription = ""
        )
        SpacerVertical(spaceSize = MaterialTheme.dimension.padding16)

        Row(
            modifier = Modifier.padding(vertical = MaterialTheme.dimension.padding16).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier.weight(1f)) {
                Text(   modifier = Modifier.basicMarquee(),
                    text = nameOfTrack,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.alpha(.7f), text = nameOfSheikh,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1
                )
            }
            IconButton(onClick = {clickFavorite()}) {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "")
            }
        }

    }
}