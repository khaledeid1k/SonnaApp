package com.sonna.screens.setting.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sonna.common.theme.dimension
import com.sonna.screens.setting.SettingComponent

@Composable
fun SettingsFeatures(settingComponents:List<SettingComponent>, moveToDetails:()->Unit) {
    LazyColumn(modifier = Modifier
        .padding(MaterialTheme.dimension.spacing16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.spacing16)){
        items(settingComponents){item->
            SettingCard(item,moveToDetails={moveToDetails()})
        }
    }
}