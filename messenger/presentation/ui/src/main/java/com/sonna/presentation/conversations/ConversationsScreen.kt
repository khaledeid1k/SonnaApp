package com.sonna.presentation.conversations

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.viewmodel.ConversationsViewModel

@Composable
fun ConversationsScreen(
    mViewModel:ConversationsViewModel = hiltViewModel()
) {
    ConversationsContent()
}

@Composable
fun ConversationsContent() {

}

@Preview(showBackground = true)
@Composable
fun ConversationsPreview() {
    ConversationsScreen()
}