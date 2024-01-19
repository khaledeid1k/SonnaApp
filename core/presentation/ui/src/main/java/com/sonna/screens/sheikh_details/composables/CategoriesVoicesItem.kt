package com.sonna.screens.sheikh_details.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.sonna.common.theme.dimension
import com.sonna.screens.sheikh_details.CategoryVoiceState

@Composable
fun CategoriesVoicesItem(categoryVoiceState : CategoryVoiceState) {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            start = MaterialTheme.dimension.spacing16,
            top= MaterialTheme.dimension.padding16
        )){

        Text(text = categoryVoiceState.numberOfVoice.toString())

        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(MaterialTheme.dimension.height50)
                .width(MaterialTheme.dimension.width100)
                .clip(RoundedCornerShape( MaterialTheme.dimension.spacing16))
                .padding(horizontal = MaterialTheme.dimension.spacing16),
            painter = painterResource(id = categoryVoiceState.picture),
            contentDescription = "")

        Column {
            Text( text = categoryVoiceState.nameOfVoice,
                style= MaterialTheme.typography.titleSmall,

                )

            Text(text = categoryVoiceState.dateOfVoice.toString(),
                modifier = Modifier.alpha(0.7f),
                style = MaterialTheme.typography.labelSmall)
        }



    }
}