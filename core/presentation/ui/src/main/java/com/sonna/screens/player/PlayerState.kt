package com.sonna.screens.player

import com.sonna.common.R

data class PlayerState(
    val nameOfPlayList: String = "AL Tafser",
    val imageOfTrack: Int = R.drawable.shek_gamal,
    val nameOfTrack: String = "Al-Baqarah from ayah 1 to ayah 25",
    val nameOfSheikh: String = "Gamal Ali",
    val timeOfTrack:Float=40.00f,
    val speedOfTrack:Double=1.0
)
