package com.sonna.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.common.composables.SpacerVertical
import com.sonna.common.theme.dimension
import com.sonna.ui.login.composables.InputTextField
import com.sonna.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    mViewModel:LoginViewModel = hiltViewModel()
){
    LoginContent()
}

@Composable
fun LoginContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimension.padding16),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "Login", style = MaterialTheme.typography.displayLarge)
            Row {
                Text(text = "Welcome Back, ", style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold))
                Text(text = "Login to continue", style = MaterialTheme.typography.headlineSmall)
            }
        }
        InputTextField(
            label = "username",
            placeholder = "username",
        )
        SpacerVertical(spaceSize = MaterialTheme.dimension.height11)
        InputTextField(
            label = "password",
            placeholder = "password",
            visualTransformation = PasswordVisualTransformation(),
            trailingIcon = Icons.Filled.Face,
            onTrailingClick = {}
        )
        SpacerVertical(spaceSize = MaterialTheme.dimension.height11)
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Forget Password?", textAlign = TextAlign.End)
        SpacerVertical(spaceSize = MaterialTheme.dimension.height50)
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(MaterialTheme.dimension.radius10),
            onClick = {}) {
            Text(text = "Login")
        }
        SpacerVertical(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    LoginScreen()
}