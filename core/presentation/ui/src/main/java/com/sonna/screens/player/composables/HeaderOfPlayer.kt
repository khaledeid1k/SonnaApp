package com.sonna.screens.player.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun HeaderOfPlayer(nameOfPlayList: String,minimize:()->Unit) {
    Row (
        modifier = Modifier.fillMaxWidth().padding(top = MaterialTheme.dimension.padding16),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround){
        IconButton(onClick = { minimize() }) {
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription ="" )
        }
        Column ( modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            modifier = Modifier .wrapContentSize(Alignment.Center),
            text = stringResource(id = R.string.play_form_playlist),
            style = MaterialTheme.typography.titleSmall,
            )
            Text(
                modifier = Modifier ,
                text =nameOfPlayList,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        IconButton(onClick = {  }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription ="" )
        }
    }

}