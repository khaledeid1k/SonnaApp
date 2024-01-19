package com.sonna.screens.sheikh_details.composables

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun HeaderOfSheikhDetails(sheikhName:String,
                          sheikhPic:Int,
                          scrollState: ScrollState,
                          clickBack:()->Unit) {
    val scrollFraction by animateFloatAsState(targetValue = (scrollState.value .toFloat() / 300).coerceIn(0f, 1f),
        label = ""
    )

    Box(modifier =Modifier.fillMaxWidth()) {
       Image(
            modifier = Modifier
                .graphicsLayer(alpha = 1 - scrollFraction)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource
                (id =sheikhPic), contentDescription = ""
        )
        AnimatedVisibility(visible = scrollState.value==0) {
            Icon(
                modifier = Modifier
                    .padding(MaterialTheme.dimension.padding8)
                    .size(MaterialTheme.dimension.size30)
                    .clickable {
                        clickBack()
                    },
                painter = painterResource(R.drawable.back),
                contentDescription = "",
                tint = Color.White
            )
        }

        Text(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(horizontal = MaterialTheme.dimension.padding16)
            .fillMaxWidth() ,
            maxLines = 1,
            overflow= TextOverflow.Ellipsis,
            style = MaterialTheme.typography.displayLarge.copy(
                color = Color.White
            ),
            text = sheikhName)


    }
}