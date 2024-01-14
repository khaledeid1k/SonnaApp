package com.sonna.screens.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.common.R
import com.sonna.common.theme.dimension
import com.sonna.screens.content.composables.ContentListCard
import com.sonna.screens.content.composables.LastReadCard
import com.sonna.viewmodel.content.ContentViewModel

@Composable
fun ContentScreen(
    mViewModel: ContentViewModel = hiltViewModel()
) {
    ContentScreenContent()
}

@Composable
fun ContentScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MaterialTheme.dimension.padding24)
    ) {
        LastReadCard(surahName = "الفاتحة", verseNum = 5)
        TabRow(selectedTabIndex = 0) {
            for (i in 1..2) {
                Tab(
                    text = { Text("title $i") },
                    selected = i == 0,
                    onClick = { }
                )
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(vertical = MaterialTheme.dimension.padding16),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding8)
        ) {
            items(count = 5) {
                ContentListCard(
                    surahIndex = 1,
                    surahName = "الفاتحة",
                    surahEnglishName = "the opening",
                    numOfVerses = 7
                )
            }
        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewContentScreen() {
    ContentScreenContent()
}