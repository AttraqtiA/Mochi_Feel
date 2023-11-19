package com.example.mochi_feel.ui.screen.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.theme.inter

@Composable
fun MusicView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center, // Center horizontally
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Playlist",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF238A91),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(start = 32.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.sound_off),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(start = 38.dp, end = 31.dp, top = 19.dp, bottom = 13.dp)
                .height(72.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Positive Vibes Only",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF238A91),
                    )
                )
                Text(
                    text = "Mochi Feel",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF238A91),
                    )
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(4.dp)
                    .height(16.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.dots_green),
                    contentDescription = "image description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth()
                .background(color = Color(0xFF238A91))
                .padding(start = 38.dp, end = 31.dp, top = 19.dp, bottom = 13.dp)
                .height(72.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Positive Vibes Only",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                    )
                )
                Text(
                    text = "Mochi Feel",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(400),
                        color = Color.White,
                    )
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(4.dp)
                    .height(16.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.dots_white),
                    contentDescription = "image description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
//        LazyColumn {
//            items() {
//
//            }
//        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MusicPreview() {
    MusicView()
}