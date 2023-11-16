package com.example.mochi_feel.ui.screen.journalingEntry

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Tag
import com.example.mochi_feel.ui.theme.CalmGreen

@Composable
fun HomeView() {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item(content = {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        text = "Good morning Karyna!",
                        fontSize = 20.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(700),
                        color = CalmGreen,
                    )
                    Text(
                        text = "Thursday, 12 October",
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
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
                Modifier.fillMaxWidth(),
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
                        text = "15",
                        fontSize = 50.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )
                }

                Text(
                    text = "You currently have a journal streak of 15 days! Keep it up :D",
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(500),
                    color = CalmGreen,
                )
            }
        })
    }
}

@Composable
fun EntryBox(Tags: MutableList<Tag>) {
    Column(
        modifier = Modifier
            .width(339.dp)
            .height(130.dp)
            .background(color = CalmGreen, shape = RoundedCornerShape(size = 10.dp)),
    ) {
        Text(
            text = "Cake for breakfast",
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 4.dp)
        )
        Text(
            text = "08:20, Wednesday 12 October 2023",
            fontSize = 12.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (tags in Tags) {
                Row(
                    Modifier
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 5.dp)
                        )
                        .padding(start = 5.dp, top = 2.dp, end = 5.dp, bottom = 2.dp)
                ) {
                    Text(
                        text = tags.name,
                        fontSize = 8.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF238A91),
                    )
                }
            }
        }

        Text(
            text = "This morning I came down for breakfast and found a huge strawberry cake on the counter...",
            fontSize = 10.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun HomePreview() {
    val Tags: MutableList<Tag> = mutableListOf(Tag(name = "lost hope"), Tag(name = "tired of life"))
    EntryBox(Tags)
//    HomeView()
}