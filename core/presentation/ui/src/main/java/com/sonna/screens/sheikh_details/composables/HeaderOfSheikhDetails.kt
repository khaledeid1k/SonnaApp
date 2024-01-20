package com.sonna.screens.sheikh_details.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun HeaderOfSheikhDetails(sheikhName:String,
                          sheikhPic:Int,
                          scrollState: ScrollState,
                          clickBack:()->Unit) {
    Box(modifier =Modifier.fillMaxWidth()) {
       Image(
            modifier = Modifier
                .graphicsLayer(alpha = 1 - (scrollState.value / 800f))
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource
                (id =sheikhPic), contentDescription = ""
        )
            IconButton(onClick = {   clickBack() }) {
                Icon(
                    modifier = Modifier
                        .padding(MaterialTheme.dimension.padding8)
                        .size(MaterialTheme.dimension.size30),
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