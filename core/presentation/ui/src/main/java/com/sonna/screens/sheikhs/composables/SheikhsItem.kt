package com.sonna.screens.sheikhs.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
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
import androidx.compose.ui.text.style.TextOverflow
import com.sonna.common.theme.dimension
import com.sonna.screens.sheikhs.SheikhState

@Composable
fun SheikhsItem(sheikhState:SheikhState) {
    Card ( elevation =cardElevation(MaterialTheme.dimension.elevation4) ){
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(id = sheikhState.photoSheik),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(MaterialTheme.dimension.padding16)
                    .size(MaterialTheme.dimension.size150)
                    .clip(CircleShape))


        }
        Text(
            text = stringResource(id = sheikhState.nameOfSheik),
            Modifier .padding(horizontal = MaterialTheme.dimension.padding16),
            style = MaterialTheme.typography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = stringResource(id = sheikhState.hintAboutSheik),
           style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.dimension.padding32,
                    top = MaterialTheme.dimension.padding8,
                    start = MaterialTheme.dimension.padding16,
                )
                .alpha(.7f)
        )
    }
}

