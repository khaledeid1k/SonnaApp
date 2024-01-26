package com.sonna.screens.player.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sonna.common.composables.SpacerHorizontal

@Composable
fun BottomOfPlayer() {
    Row(modifier = Modifier,
        ) {
        SpacerHorizontal(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(modifier = Modifier.size(18.dp), imageVector = Icons.Default.Share, contentDescription = "")
        }

        IconButton(onClick = {}) {
            Icon(modifier = Modifier.size(20.dp),imageVector = Icons.Default.List, contentDescription = "")
        }
    }
}