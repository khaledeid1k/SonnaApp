package com.sonna.presentation.conversations.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun UserAvatar(userImg: String) {
    Image(
        modifier = Modifier
            .size(MaterialTheme.dimension.size70)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary),
        painter = if (userImg.isBlank()) painterResource(id = R.drawable.quran) else rememberAsyncImagePainter(
            userImg
        ),
        contentDescription = null
    )
}