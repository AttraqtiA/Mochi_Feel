package com.example.mochi_feel.ui.screen.journalingEntry

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.ui.screen.components.OneEntryBox
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.inter
import com.example.mochi_feel.viewmodel.Journaling_Entry.HomeViewModel

@Composable
fun HomeView(
    homeViewModel: HomeViewModel = viewModel()
) {
    val variabel_UIState by homeViewModel.uiState.collectAsState()

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(top = 24.dp, start = 24.dp, end = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item(content = {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        text = "Good morning ${variabel_UIState.username}!",
                        fontSize = 20.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(700),
                        color = CalmGreen,
                    )
                    Text(
                        text = "${variabel_UIState.getCurrentDate()}",
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(400),
                        color = CalmGreen,
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.homepage),
                    contentDescription = "Mochi at Home",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable(onClick = {
                            Toast
                                .makeText(
                                    context, "Are you feeling better now?", Toast.LENGTH_SHORT
                                )
                                .show()
                        })
                        .width(240.dp)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    Modifier
                        .width(80.dp)
                        .background(
                            color = CalmGreen, shape = RoundedCornerShape(size = 5.dp)
                        ), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${variabel_UIState.streak}",
                        fontSize = 50.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )
                }

                Text(
                    text = "You currently have a journal streak of ${variabel_UIState.streak} days! Keep it up :D",
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(500),
                    color = CalmGreen,
                )
            }

            Divider(
                color = CalmGreen,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp)
                    .height(1.dp)
            )

            if (variabel_UIState.EntryBoxList.size == 0) {
                ToAddEntryButton0()
            } else {
                ToAddEntryButton1()
            }
        })


        items(variabel_UIState.EntryBoxList) { entrybox: EntryBox ->
            OneEntryBox(
                entrybox.title,
                entrybox.time,
                entrybox.getEntryBoxDate(),
                entrybox.tags_list,
                entrybox.entry
            )
        }
    }
}

@Composable
fun ToAddEntryButton0() {
    Row(
        Modifier
            .padding(bottom = 24.dp)
            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 10.dp))
    ) {
        Text(
            text = "+ Start writing your first entry",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 32.dp)
        )
    }
}

@Composable
fun ToAddEntryButton1() {
    Row(
        Modifier
            .padding(bottom = 24.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .border(
                width = 1.dp,
                color = CalmGreen,
                shape = RoundedCornerShape(size = 10.dp)
            )
    ) {
        Text(
            text = "+ Write another entry",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(600),
                color = Color(0xFF238A91),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 64.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
//    val Tags: MutableList<Tag> = mutableListOf(Tag(name = "lost hope"), Tag(name = "tired of life"))
//    EntryBox(Tags)
    HomeView()
}