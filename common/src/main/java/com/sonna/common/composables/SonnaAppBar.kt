package com.sonna.common.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.sonna.common.R
import com.sonna.common.theme.dimension

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SonnaAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    navigationBack: () -> Unit = {},
    navigationIconDisability: Boolean = true,
     titleOfTopBar: String,
){
    TopAppBar(
        navigationIcon = {
            AnimatedVisibility(visible = navigationIconDisability) {
                Icon(
                    modifier = Modifier
                        .padding(end = MaterialTheme.dimension.padding8)
                        .size(MaterialTheme.dimension.size30)
                        .clickable {
                            navigationBack()
                        },
                    painter = painterResource(R.drawable.back),
                    contentDescription = ""
                )
            }

        },
        title = {
                Text(text = titleOfTopBar,
                    style = MaterialTheme.typography.titleMedium,)
                },
        scrollBehavior = scrollBehavior
    )
    
}