package com.sonna.screens.pop.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun ContentOfPop(style: TextStyle
                 , text:String) {
    Text(
        style =style,
        text = text,
    )
}