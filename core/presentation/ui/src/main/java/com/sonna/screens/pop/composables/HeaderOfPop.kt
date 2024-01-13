package com.sonna.screens.pop.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.sonna.common.R
import com.sonna.common.composables.SpacerHorizontal
import com.sonna.common.theme.dimension

@Composable
fun HeaderOfPop(

    play:()->Unit,
    done:()->Unit,
    share:()->Unit,
    close:()->Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Icon(
            modifier = Modifier.wrapContentSize().clickable { play() },
            painter = painterResource(id = R.drawable.play),
            contentDescription = ""
        )
        SpacerHorizontal(MaterialTheme.dimension.spacing16)
        Icon(
            modifier = Modifier.wrapContentSize().clickable { done() },
            painter = painterResource(id = R.drawable.done),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.weight(3f))
        Icon(
            modifier = Modifier .wrapContentSize().clickable { share() },
            painter = painterResource(id = R.drawable.share),
            contentDescription = ""
        )

        SpacerHorizontal(MaterialTheme.dimension.spacing16)
        Icon(
            modifier = Modifier.wrapContentSize().clickable { close() },
            painter = painterResource(id = R.drawable.close),
            contentDescription = ""
        )


    }
}