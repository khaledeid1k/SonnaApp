package com.sonna.screens.settingDetails.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sonna.common.composables.SpacerVertical
import com.sonna.common.theme.dimension
import com.sonna.screens.settingDetails.SettingDetailState


@Composable
fun ValueSettingDetails(
    settingDetailState: SettingDetailState,
    changeValueOfSetting: () -> Unit,
    itemClick: () -> Unit={}) {
Column {
    SpacerVertical(MaterialTheme.dimension.spacing10)
    Row(
        modifier = Modifier
            .wrapContentSize()
            .clickable { itemClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier
                .padding(end = MaterialTheme.dimension.spacing16)
                .size(MaterialTheme.dimension.size30)
                .clickable(enabled = false) {},
            painter = painterResource(settingDetailState.iconOfItem),
            contentDescription = ""
        )

        Text(
            text = stringResource(id = settingDetailState.nameOfItem),
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = settingDetailState.valueOfFeature,
            modifier = Modifier.alpha(0.7f)
                .clickable {
                    changeValueOfSetting()
                }
        )

    }
    SpacerVertical(MaterialTheme.dimension.spacing10)
    Divider(Modifier.padding(vertical = MaterialTheme.dimension.padding4).alpha(2f),thickness = MaterialTheme.dimension.thickness1)

}
}


@Composable
fun SwitchSettingDetails(settingDetailState: SettingDetailState,
                         changeValueOfSetting: () -> Unit) {

    var checked by remember { mutableStateOf(false) }
    Column {
        SpacerVertical(MaterialTheme.dimension.spacing10)


        Row(
            modifier = Modifier
                .wrapContentSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .padding(end = MaterialTheme.dimension.spacing16)
                    .size(MaterialTheme.dimension.size30)
                    .clickable(enabled = false) {},
                painter = painterResource(settingDetailState.iconOfItem),
                contentDescription = ""
            )

            Text(
                text = stringResource(id = settingDetailState.nameOfItem),
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.weight(1f))

            Switch(
                modifier = Modifier
                    .clickable { changeValueOfSetting() },
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )
        }
        SpacerVertical(MaterialTheme.dimension.spacing10)
        Divider(
            Modifier
                .padding(vertical = MaterialTheme.dimension.padding4)
                .alpha(2f), thickness = MaterialTheme.dimension.thickness1
        )

    }

}
@Preview
@Composable
fun ValueSettingDetailsPreview() {
    ValueSettingDetails(settingDetailState=SettingDetailState(),{}){}
}




@Preview
@Composable
fun  SwitchSettingDetailsPreview() {
    SwitchSettingDetails(settingDetailState=SettingDetailState()){}
}


