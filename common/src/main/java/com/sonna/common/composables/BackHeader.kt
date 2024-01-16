package com.sonna.common.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun BackHeader(modifier:Modifier = Modifier, @StringRes title:Int, backToHome:()->Unit ) {
    Row (modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            modifier = Modifier
                .padding(end = MaterialTheme.dimension.padding8)
                .size(MaterialTheme.dimension.size30)
                .clickable {
                    backToHome()
                },
            painter = painterResource(R.drawable.back),
            contentDescription = ""
        )
        Text(text = stringResource(id = title),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}