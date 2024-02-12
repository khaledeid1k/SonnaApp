package com.sonna.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sonna.common.R
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.screens.home.navigateToHome
import com.sonna.viewmodel.splash.SplashUiState
import com.sonna.viewmodel.splash.SplashViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    mViewModel: SplashViewModel = hiltViewModel()
) {
    val state by mViewModel.state.collectAsState()
    SplashContent(state) {
        navController.navigateToHome(true)
    }
}

@Composable
fun SplashContent(
    state: SplashUiState = SplashUiState(),
    onComplete: () -> Unit = {}
) {
    LaunchedEffect(key1 = state.isQuranLoading, block = {
        if (!state.isQuranLoading && !state.isAzkarLoading) {
            onComplete()
        }
    })
    LaunchedEffect(key1 = state.isAzkarLoading, block = {
        if (!state.isQuranLoading && !state.isAzkarLoading) {
            onComplete()
        }
    })
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
    ) {
        val (image, loader, error) = createRefs()
        Image(
            modifier = Modifier.constrainAs(image) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            painter = painterResource(id = R.drawable.quran), contentDescription = null
        )
        if (state.isQuranLoading || state.isAzkarLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(64.dp)
                    .constrainAs(loader) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(image.bottom)
                        bottom.linkTo(parent.bottom)
                    },
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
        Text(
            modifier = Modifier.constrainAs(error) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(image.bottom)
                bottom.linkTo(parent.bottom)
            },
            text = state.error?.message ?: "", style = TextStyle(color = Color.Red)
        )

    }
}

@ThemePreviews
@Composable
fun SplashPreview() {
    SonnaAppTheme {
        SplashContent()
    }
}