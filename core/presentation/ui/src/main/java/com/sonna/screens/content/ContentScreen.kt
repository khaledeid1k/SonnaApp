package com.sonna.screens.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .height(202.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF006754),
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Last Read", color = Color.White, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = "الفاتحة",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Ayah no. 1", color = Color.White, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(14.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        onClick = { }
                    ) {
                        Row {
                            Text(text = "Continue", color = Color.Black)
                            Icon(
                                Icons.Rounded.ArrowForward,
                                contentDescription = "arrow",
                                tint = Color.Black
                            )
                        }
                    }
                }
                Image(
                    modifier = Modifier
                        .padding(0.dp)
                        .width(202.16774.dp)
                        .height(202.16774.dp),
                    painter = painterResource(id = R.drawable.quran),
                    contentScale = ContentScale.None,
                    contentDescription = "card background"
                )
            }


        }
        TabRow(selectedTabIndex = 0) {
            for (i in 1..2){
                Tab(
                    text = { Text("title $i") },
                    selected = i == 0,
                    onClick = {  }
                )
            }
            /*titles.forEachIndexed { index, title ->

            }*/
        }
        LazyColumn{
            items(count = 5){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ){
                    Card(
                        modifier = Modifier.size(50.dp),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "1")
                        }
                    }
                    Spacer(modifier = Modifier.width(19.dp))
                    Column (
                        modifier = Modifier.height(50.dp),
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(text = "Al-Faatiha")
                        Text(text = "The Opening 7", color = Color.LightGray)
                    }
                }


            }
        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewContentScreen() {
    ContentScreenContent()
}