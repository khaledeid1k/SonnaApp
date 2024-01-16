package com.sonna.ui.conversations.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sonna.common.theme.dimension

@Composable
fun ConversationCard(
    userImg: String = "",
    username: String,
    subTitle: String,
    trailingTitle: String="",
    isOnline: Boolean? = null,
    roundedCorner: Dp = 10.dp


) {
    Card (
        shape = RoundedCornerShape(roundedCorner)
    ){
        Row(
            modifier = Modifier.padding(MaterialTheme.dimension.padding8),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                if (isOnline!=null) {
                    Box(
                        modifier = Modifier
                            .size(MaterialTheme.dimension.size10)
                            .clip(CircleShape)
                            .background(if (isOnline == true) Color.Green else Color.Red)
                    )
                }
                UserAvatar(userImg)
            }
            Spacer(modifier = Modifier.width(MaterialTheme.dimension.width8))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = username, style = MaterialTheme.typography.titleMedium)
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    //SeenCheck()
                    if (roundedCorner!=0.dp) {
                        Icon(
                            imageVector = Icons.Rounded.Done,
                            contentDescription = null,
                            tint = Color.LightGray
                        )
                    }
                    Text(text = subTitle, style = MaterialTheme.typography.labelSmall)
                }
            }
            Text(
                text = if (isOnline == true) "" else trailingTitle,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}