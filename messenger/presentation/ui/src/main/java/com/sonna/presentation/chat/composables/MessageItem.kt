package com.sonna.presentation.chat.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.sonna.common.theme.dimension

@Composable
fun MessageItem(
    message: String,
    time: String,
    isSeen: Boolean,
    fromMessage: Boolean
) {
    Row {
        if (!fromMessage) {
            Spacer(modifier = Modifier.weight(1f))
        }
        Box(
            modifier = Modifier
                .weight(3f)
                .clip(
                    RoundedCornerShape(
                        topStart = MaterialTheme.dimension.radius10,
                        topEnd = MaterialTheme.dimension.radius10,
                        bottomStart = if (fromMessage) MaterialTheme.dimension.radius0 else MaterialTheme.dimension.radius10,
                        bottomEnd = if (fromMessage) MaterialTheme.dimension.radius10 else MaterialTheme.dimension.radius0,
                    )
                )
                .background(if (fromMessage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary)
        ) {
            Column(
                modifier = Modifier.padding(MaterialTheme.dimension.padding4),
                horizontalAlignment = if (fromMessage) Alignment.Start else Alignment.End
            ) {
                Text(
                    text = message,
                    textAlign = if (fromMessage) TextAlign.Start else TextAlign.End,
                    style = MaterialTheme.typography.bodyMedium.copy(color = if (fromMessage) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Rounded.Done,
                        contentDescription = null,
                        tint = if (isSeen) Color.Blue else Color.LightGray
                    )
                    Text(
                        text = time,
                        style = MaterialTheme.typography.labelSmall.copy(color = if (fromMessage) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSecondaryContainer)
                    )
                }
            }
        }
        if (fromMessage) {
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}