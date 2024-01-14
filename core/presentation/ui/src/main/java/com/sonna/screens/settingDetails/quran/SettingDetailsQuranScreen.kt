package com.sonna.screens.settingDetails.quran

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sonna.common.theme.dimension
import com.sonna.screens.settingDetails.composables.SettingEnabledItemScreen

@Composable
fun SettingDetailsQuranScreen() {
    SettingDetailsQuranContent(SettingDetailsQuranState())
}



@Composable
fun SettingDetailsQuranContent(settingDetailsQuranState:SettingDetailsQuranState) {
    LazyColumn(modifier = Modifier
        .padding(MaterialTheme.dimension.spacing16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.spacing16)){
        items(settingDetailsQuranState.settingDetailsQuranItem){item->
            SettingEnabledItemScreen(item)
        }
    }
}


@Preview
@Composable
fun SettingDetailsQuranPreview() {
    SettingDetailsQuranContent(SettingDetailsQuranState())
}

