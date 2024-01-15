package com.sonna.screens.details.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun VerseItem(
    arabicVerse: String,
    englishVerse: String
) {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = arabicVerse,
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = englishVerse, textAlign = TextAlign.Left,
            style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Light)
        )
    }
}