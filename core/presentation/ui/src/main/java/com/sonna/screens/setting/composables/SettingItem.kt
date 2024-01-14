package com.sonna.screens.setting.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sonna.common.R
import com.sonna.common.theme.dimension
import com.sonna.screens.setting.SettingComponent


@Composable
fun SettingCard(settingData: SettingComponent, moveToDetails: () -> Unit) {
    Card(modifier = Modifier.wrapContentSize()) {
        Row(
            modifier = Modifier
                .padding(MaterialTheme.dimension.spacing16)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .padding(end = MaterialTheme.dimension.spacing16)
                    .size(MaterialTheme.dimension.size30)
                    .clickable(enabled = false) {},
                painter = painterResource(settingData.iconOfItem),
                contentDescription = ""
            )

            Text(
                text = stringResource(id = settingData.nameOfItem),
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { moveToDetails() },
                painter = painterResource(id = R.drawable.got_to),
                contentDescription = ""
            )
        }
    }

}

@Preview
@Composable
fun SettingPreview() {
    SettingCard(SettingComponent(iconOfItem = R.drawable.quarn, nameOfItem = R.string.hadith)) {}
}