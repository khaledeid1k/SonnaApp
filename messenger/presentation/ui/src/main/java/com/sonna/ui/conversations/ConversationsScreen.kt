package com.sonna.ui.conversations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.common.theme.dimension
import com.sonna.ui.conversations.composables.ConversationCard
import com.sonna.viewmodel.ConversationsViewModel

@Composable
fun ConversationsScreen(
    mViewModel:ConversationsViewModel = hiltViewModel()
) {
    ConversationsContent()
}

@Composable
fun ConversationsContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.spacing10),
            contentPadding = PaddingValues(MaterialTheme.dimension.padding16)
        ){
            items(5){
                ConversationCard(
                    username = "Mohannad Ahmed",
                    subTitle = "hello",
                    trailingTitle = "03:00 am\n7/10/2023",
                    isOnline = false
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConversationsPreview() {
    ConversationsScreen()
}