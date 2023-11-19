package com.example.mochi_feel.ui.screen.help

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.inter

@Composable
fun HelpMainView() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF9FFFF))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                contentDescription = "back button",
                tint = CalmGreen,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "What are you\nthinking of writing\nabout?",
            style = TextStyle(
                fontSize = 28.sp,
                lineHeight = 28.sp,
                fontFamily = inter,
                fontWeight = FontWeight(700),
                color = Color(0xFF238A91),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .width(279.dp)
                .height(93.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(148.dp)
                .height(148.dp)
                .shadow(
                    elevation = 40.dp,
                    spotColor = Color(0xFF238A91),
                    ambientColor = Color(0xFF238A91)
                )
                .background(color = Color(0xFF4ABDC0), shape = RoundedCornerShape(size = 10.dp)),
            ) {
            Image(
                painter = painterResource(id = R.drawable.help_1),
                contentDescription = "Something Random Icon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(88.dp)
                    .height(88.dp)
            )
            Text(
                text = "Something\nRandom",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .width(107.dp)
                    .height(47.dp)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(148.dp)
                .height(148.dp)
                .shadow(
                    elevation = 40.dp,
                    spotColor = Color(0xFF238A91),
                    ambientColor = Color(0xFF238A91)
                )
                .background(color = Color(0xFF4ABDC0), shape = RoundedCornerShape(size = 10.dp)),
        ) {
            Image(
                painter = painterResource(id = R.drawable.help_2),
                contentDescription = "My Emotions Icon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(88.dp)
                    .height(88.dp)
            )
            Text(
                text = "My\nEmotions",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .width(107.dp)
                    .height(47.dp)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HelpMainPreview() {
    HelpMainView()
}