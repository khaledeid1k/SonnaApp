package com.sonna.screens.content.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun LastReadCard(
    surahName:String,
    verseNum:Int
){
    Card(
        modifier = Modifier
            .padding(MaterialTheme.dimension.padding16)
            .fillMaxWidth()
            .height(MaterialTheme.dimension.height202),
        shape = RoundedCornerShape(MaterialTheme.dimension.radius16),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.dimension.padding16),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Last Read", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(MaterialTheme.dimension.height11))
                Text(text = surahName, style = MaterialTheme.typography.bodySmall)
                Text(text = "Ayah no. $verseNum", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(MaterialTheme.dimension.height14))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    onClick = { }
                ) {
                    Row {
                        Text(text = "Continue", color = Color.Black)
                        Icon(
                            Icons.Rounded.ArrowForward,
                            contentDescription = "arrow",
                            tint = Color.Black
                        )
                    }
                }
            }
            Image(
                modifier = Modifier
                    .width(MaterialTheme.dimension.width202)
                    .height(MaterialTheme.dimension.height202),
                painter = painterResource(id = R.drawable.quran),
                contentScale = ContentScale.None,
                contentDescription = "card background"
            )
        }


    }
}