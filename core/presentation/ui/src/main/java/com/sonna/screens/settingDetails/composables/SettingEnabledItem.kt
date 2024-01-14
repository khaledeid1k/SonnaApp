package com.sonna.screens.settingDetails.composables

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sonna.common.R
import com.sonna.common.theme.dimension
import com.sonna.screens.settingDetails.quran.SettingDetailItem

@Composable
fun SettingEnabledItemScreen( settingDetailItem:SettingDetailItem){
    SettingEnabledItemContent(
        settingDetailItem=settingDetailItem
    ) {}
}
@Composable
fun SettingEnabledItemContent(
    settingDetailItem: SettingDetailItem,
    changeValueOfSetting: () -> Unit) {

    var checked by remember { mutableStateOf(false) }

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
                painter = painterResource(settingDetailItem.iconOfItem),
                contentDescription = ""
            )

            Text(
                text = stringResource(id = settingDetailItem.nameOfItem),
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.weight(1f))

            Switch(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { changeValueOfSetting() },
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )
        }
    }

}

@Preview
@Composable
fun SettingEnabledItemPreview() {
    SettingEnabledItemContent(settingDetailItem=SettingDetailItem()){}
}