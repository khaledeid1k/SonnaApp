package com.sonna.common.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
@Composable
fun SpacerVertical(spaceSize: Dp =0.dp) {
    Spacer(modifier = Modifier.height(spaceSize))


}