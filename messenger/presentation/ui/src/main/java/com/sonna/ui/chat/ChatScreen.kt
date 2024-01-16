package com.sonna.ui.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.common.theme.dimension
import com.sonna.ui.chat.composables.ChatTextField
import com.sonna.ui.chat.composables.MessageItem
import com.sonna.ui.conversations.composables.ConversationCard
import com.sonna.viewmodel.ChatViewModel

@Composable
fun ChatScreen(
    mViewModel: ChatViewModel = hiltViewModel()
) {
    ChatContent()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChatContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = MaterialTheme.dimension.padding8)
    ) {
        Row {
            ConversationCard(username = "mohannad", subTitle = "7/10/2023",roundedCorner=0.dp)
        }
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = MaterialTheme.dimension.padding8,
                vertical = MaterialTheme.dimension.padding8),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.spacing10),
        ) {
            items(9) {
                MessageItem(
                    message = "message message message message message",
                    time = "12:00 pm",
                    isSeen = false,
                    it % 2 == 0
                )
            }
        }
        ChatTextField()
    }
}

@Preview(showBackground = true)
@Composable
fun ChatPreview() {
    ChatScreen()
}