package com.sonna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.screens.content.ContentScreen
import com.sonna.screens.setting_details.hadith.SettingDetailsHadithContent
import com.sonna.screens.setting_details.hadith.SettingDetailsHadithScreen
import com.sonna.screens.sheikhs.SheikhsScreen
import com.sonna.viewmodel.setting_details.hadith.HadithSettingState
import com.sonna.viewmodel.setting_details.hadith.SettingHadithActions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SonnaAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //ContentScreen()
                    SettingDetailsHadithScreen()
                }
            }
        }
    }
}
