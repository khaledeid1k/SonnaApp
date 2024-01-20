package com.sonna.screens.sheikh_details.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.sonna.common.composables.Title
import com.sonna.common.theme.dimension
import com.sonna.common.R
import com.sonna.screens.sheikh_details.About


@Composable
fun AboutSheikh(about: About) {
    Column {

        Title(
            text = stringResource(id = R.string.about),
            modifier = Modifier.padding(start = MaterialTheme.dimension.padding16),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimension.padding16)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(MaterialTheme.dimension.radius6))
                    .height(MaterialTheme.dimension.height191),
                painter = painterResource(id = about.picture),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(MaterialTheme.dimension.padding16),

                text = about.description,
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )

        }

    }
}