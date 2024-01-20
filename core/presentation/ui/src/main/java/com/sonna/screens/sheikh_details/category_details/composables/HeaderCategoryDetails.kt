package com.sonna.screens.sheikh_details.category_details.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun HeaderCategoryDetails(
    categoryPic: Int,
    titleOfCategory: String,
    numberOfTracks: Int,
    timeOfPublished: Int,
    nameOfSheikh: String,
    clickBack:()->Unit
) {
    IconButton(onClick = {   clickBack() }) {
        Icon(
            modifier = Modifier
                .padding(MaterialTheme.dimension.padding8)
                .size(MaterialTheme.dimension.size30),
            painter = painterResource(R.drawable.back),
            contentDescription = "",
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(MaterialTheme.dimension.padding8),
    ) {
        Image(
            modifier = Modifier
                .size(MaterialTheme.dimension.size150)
                .clip(RoundedCornerShape(MaterialTheme.dimension.radius6)),
            painter = painterResource(id = categoryPic),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = MaterialTheme.dimension.padding8)
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.dimension.padding8),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.align(Alignment.End),
                text = titleOfCategory,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "${stringResource(id = R.string.playlist)} : $numberOfTracks ${stringResource(id = R.string.tracks)}\n$timeOfPublished d ago",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.alpha(.7f)
            )
            Text(
                text = "by $nameOfSheikh",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.alpha(.9f)
            )
        }
    }
}