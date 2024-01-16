package com.sonna.screens.home.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.sonna.common.R
import com.sonna.common.composables.SpacerHorizontal
import com.sonna.common.theme.dimension

@Composable
fun BottomOfPop(nameOfSura:String,
                numberOfAya:String,
                next:()->Unit,
                previous:()->Unit,
                favorite:()->Unit,
                ) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier .wrapContentSize().clickable {
                                                             previous()
            },
            painter = painterResource(id = R.drawable.previous),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier .wrapContentSize().clickable {
                favorite()
            },
            painter = painterResource(id = R.drawable.favorite),
            contentDescription = ""
        )
        SpacerHorizontal(spaceSize = MaterialTheme.dimension.spacing10)

        Text(
            style = MaterialTheme.typography.bodySmall,
            text = "$nameOfSura - $numberOfAya"
        )

        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier .wrapContentSize().clickable {
                next()
            },
            painter = painterResource(id = R.drawable.next),
            contentDescription = ""
        )

    }

}