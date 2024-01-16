package com.sonna.ui.forgetpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.sonna.viewmodel.ForgetPasswordViewModel

@Composable
fun ForgetPasswordScreen(
    mViewModel:ForgetPasswordViewModel = hiltViewModel()
){
    ForgetPasswordContent()
}

@Composable
fun ForgetPasswordContent(){
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Forget your password?", style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold))
            Text(text = "Enter your email address and we will share a link to create a new password.", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Light), textAlign = TextAlign.Center)
        }
        InputTextField(
            label = "",
            placeholder = "Enter Email Address",
        )
        SpacerVertical(spaceSize = MaterialTheme.dimension.height50)
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(MaterialTheme.dimension.radius10),
            onClick = {}) {
            Text(text = "Send")
        }
        SpacerVertical(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun ForgetPasswordPreview(){
    ForgetPasswordScreen()
}