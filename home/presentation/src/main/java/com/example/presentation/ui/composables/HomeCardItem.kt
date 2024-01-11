package com.example.presentation.ui.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.Radius23
import com.example.designsystem.theme.SonnaAppTheme
import com.example.designsystem.theme.Spacing16
import com.example.designsystem.theme.TextSize16
import com.example.designsystem.R


@Composable
fun HomeCardItem(
    modifier: Modifier = Modifier,
    color: Color,
    height: Dp,
    @StringRes title: Int,
    @DrawableRes image: Int
) {
    Card(
        modifier = modifier
            .height(height)
            .fillMaxWidth(),
        colors =CardDefaults.cardColors(containerColor = color),
        shape = RoundedCornerShape(Radius23)
    ) {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            Title(
                modifier = Modifier
                    .padding(top = Spacing16, start = Spacing16)
                ,
                text = stringResource(id = title),
                textsStyle = MaterialTheme.typography.titleMedium.copy(fontSize = TextSize16)
            )
            Image(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = Spacing16, bottom = Spacing16)
                ,
                painter = painterResource(id = image),
                contentDescription = ""
            )
        }
    }

}

@Preview
@Composable
fun HomeCardPreview() {
    SonnaAppTheme {
        HomeCardItem(
        color = Color.White,
        height = 191.dp,
         title = R.string.popular,
         image = R.drawable.quarn)
    }
}