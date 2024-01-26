package com.sonna.screens.player.min_player

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.sonna.common.R
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.dimension

@ThemePreviews
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MiniPlayer(
    miniPlayerState: MiniPlayerState = MiniPlayerState(),
    clickFavorite: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(MaterialTheme.dimension.padding8))
            .background(MaterialTheme.colorScheme.primary)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.dimension.padding8)
                .size(MaterialTheme.dimension.size50)
                .clip(
                    RoundedCornerShape(MaterialTheme.dimension.radius8)
                ),
            painter = painterResource(id = miniPlayerState.imageOfTrack),
            contentDescription = ""
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                modifier = Modifier.basicMarquee(),
                text = miniPlayerState.nameOfTrack,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.alpha(.7f), text = miniPlayerState.nameOfSheikh,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1
            )
        }
        IconButton(onClick = { clickFavorite() }) {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "")
        }
        IconButton(
            onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.mini_play),
                contentDescription = "",
            )
        }
    }
}