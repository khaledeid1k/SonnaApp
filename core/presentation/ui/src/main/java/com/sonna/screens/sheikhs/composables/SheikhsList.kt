package com.sonna.screens.sheikhs.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sonna.common.theme.dimension
import com.sonna.screens.sheikhs.SheikhState

@Composable
fun SheikhsList(sheikhs: List<SheikhState> ) {
    LazyVerticalGrid(
        modifier = Modifier.padding(MaterialTheme.dimension.padding16),
        columns = GridCells.Adaptive(MaterialTheme.dimension.size150),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding16)
    ) {
        items(sheikhs) { sheikh ->
            SheikhsItem(sheikh)
        }
    }
}