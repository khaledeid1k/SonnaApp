package com.sonna.screens.setting.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun HeaderOfSetting(backToHome:()->Unit) {
    Row (modifier = Modifier
        .padding(
            horizontal = MaterialTheme.dimension.spacing16,
            vertical =  MaterialTheme.dimension.spacing16)){
        Icon(
            modifier = Modifier
                .padding(end = MaterialTheme.dimension.spacing16)
                .size(MaterialTheme.dimension.size30)
                .clickable {
                    backToHome()
                },
            painter = painterResource(R.drawable.back),
            contentDescription = ""
        )
        Text(text = stringResource(id = R.string.setting),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}