package com.sonna.screens.sheikh_details.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import com.sonna.common.R
import com.sonna.common.composables.SpacerHorizontal
import com.sonna.common.theme.dimension

@Composable
fun ControlPanel(
    hintAboutSheikh: String,
    clickFavorite: () -> Unit,
    clickMore: () -> Unit ,
    clickRandom: () -> Unit ,
    clickPlay: () -> Unit ,
    hasHint:Boolean=true
) {

    if(hasHint) {
        Text(
            text = hintAboutSheikh,
            modifier = Modifier
                .padding(MaterialTheme.dimension.padding16)
                .alpha(.7f),
            style = MaterialTheme.typography.labelSmall
        )
    }
    Row(
        Modifier.padding(horizontal = MaterialTheme.dimension.padding16),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(
            onClick = {
                clickFavorite()
            },
            modifier = Modifier.padding(horizontal = MaterialTheme.dimension.padding8),
        ) {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "")

        }
        IconButton(
            onClick = {
                clickMore()
            },
            modifier = Modifier.padding(horizontal = MaterialTheme.dimension.padding8),
        ) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")

        }

        SpacerHorizontal(modifier = Modifier.weight(1f))

        IconButton(
            onClick = {
                clickRandom()
            },
            modifier = Modifier.padding(horizontal = MaterialTheme.dimension.padding8),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.random),
                contentDescription = ""
            )
        }

        IconButton(
            onClick = {
                clickPlay()
            },
            modifier = Modifier
                .size(MaterialTheme.dimension.size60)
                .padding(horizontal = MaterialTheme.dimension.padding8),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.play),
                contentDescription = "", tint = MaterialTheme.colorScheme.primary
            )
        }


    }
}