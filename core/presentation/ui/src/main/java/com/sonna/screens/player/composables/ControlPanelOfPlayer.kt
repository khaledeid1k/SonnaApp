package com.sonna.screens.player.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sonna.common.theme.dimension
import com.sonna.common.R
import com.sonna.common.composables.SpacerHorizontal
import java.util.concurrent.TimeUnit

@Composable
fun ControlPanelOfPlayer(timeOfTrack: Float, speedOfTrack: Double) {
    Column(modifier = Modifier
       .padding(horizontal = MaterialTheme.dimension.padding16)
    ) {
        var sliderPosition by remember { mutableFloatStateOf(0f) }

        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..timeOfTrack
        )
        val seconds = sliderPosition * 60
        val hours = TimeUnit.SECONDS.toHours(seconds.toLong())
        val remainingMinutes =
            TimeUnit.SECONDS.toMinutes(seconds.toLong()) - TimeUnit.HOURS.toMinutes(hours)
        val formattedTime = String.format("%02d:%02d", hours, remainingMinutes)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
          Text(text = formattedTime)
            Text(
                text = formattedTime,
                modifier = Modifier.padding(start = MaterialTheme.dimension.padding8)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "${speedOfTrack}X",
                modifier = Modifier
                    .border(
                        MaterialTheme.dimension.thickness1,
                        MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(MaterialTheme.dimension.radius8)
                    )
                    .padding(
                        horizontal = MaterialTheme.dimension.padding4,
                        vertical = MaterialTheme.dimension.padding2
                    ),
                style = MaterialTheme.typography.labelMedium
            )

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.previous),
                    contentDescription = ""
                )
            }
            IconButton(
                modifier = Modifier.size(MaterialTheme.dimension.size60),
                onClick = {}) {
                Icon(
                    modifier = Modifier.size(MaterialTheme.dimension.size70),
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = "",
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.next),
                    contentDescription = ""
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.random),
                    contentDescription = ""
                )
            }
        }
    }

}


