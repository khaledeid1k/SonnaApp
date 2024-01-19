package com.sonna.common.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import com.sonna.common.theme.dimension

@Composable
fun DividerLine(modifier: Modifier= Modifier,
                thickness: Dp =MaterialTheme.dimension.thickness1 ) {
    Divider(
       modifier=modifier.padding(vertical = MaterialTheme.dimension.padding4).alpha(2f),
        thickness = thickness
    )

}