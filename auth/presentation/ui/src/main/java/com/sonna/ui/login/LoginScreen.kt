package com.sonna.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    mViewModel:LoginViewModel = hiltViewModel()
){
    LoginContent()
}

@Composable
fun LoginContent(){

}

@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    LoginScreen()
}