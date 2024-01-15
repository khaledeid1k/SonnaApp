package com.sonna.presentation.chat

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.viewmodel.ChatViewModel

@Composable
fun ChatScreen(
    mViewModel: ChatViewModel = hiltViewModel()
) {
    ChatContent()
}

@Composable
fun ChatContent() {

}

@Preview(showBackground = true)
@Composable
fun ChatPreview() {
    ChatScreen()
}