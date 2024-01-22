package com.sonna.screens.player

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sonna.common.composables.SonnaScaffold
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.screens.player.composables.BodOfPlayer
import com.sonna.screens.player.composables.BottomOfPlayer
import com.sonna.screens.player.composables.ControlPanelOfPlayer
import com.sonna.screens.player.composables.HeaderOfPlayer


@Composable
fun PlayerScreen() {
    PlayerContent(PlayerState())
}


@Composable
fun PlayerContent(playerState: PlayerState) {
    SonnaScaffold(
        isAppBarExisting = false,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            HeaderOfPlayer(
                nameOfPlayList = playerState.nameOfPlayList,
                minimize = {

                })

            BodOfPlayer(
                modifier = Modifier.weight(1f),
                imageOfTrack = playerState.imageOfTrack,
                nameOfTrack = playerState.nameOfTrack,
                nameOfSheikh = playerState.nameOfSheikh,
                clickFavorite = {}
            )
            ControlPanelOfPlayer(
                timeOfTrack = playerState.timeOfTrack,
                speedOfTrack = playerState.speedOfTrack
            )

            BottomOfPlayer()
        }

    }

}

@ThemePreviews
@Composable
fun PlayerPreviews() {
    SonnaAppTheme {
        PlayerContent(PlayerState())
    }
}