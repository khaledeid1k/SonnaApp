package com.sonna.common.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun Title(modifier: Modifier=Modifier,text:String,textsStyle: TextStyle=MaterialTheme.typography.titleMedium) {
    Text(
        modifier=modifier,
        text =text,
        style = textsStyle)


}