package com.sonna.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.common.R
import com.sonna.viewmodel.splash.SplashUiState
import com.sonna.viewmodel.splash.SplashViewModel

@Composable
fun SplashScreen(
    mViewModel: SplashViewModel = hiltViewModel()
) {
    val state by mViewModel.state.collectAsState()
    SplashContent(state)
}

@Composable
fun SplashContent(state: SplashUiState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.quran), contentDescription = null)
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
        if (state.error != null) {
            state.error?.let {
                Text(text = it.error, style = TextStyle(color = Color.Red))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashScreen()
}