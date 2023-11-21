package com.example.mochi_feel.ui.screen.help

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.mochi_feel.model.Topic
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.inter
import com.example.mochi_feel.viewmodel.Random.RandomViewModel

// Topic changeable. I only made 5 topics though
@Composable
fun RandomView(
    randomViewModel: RandomViewModel,
    backToNewEntry: () -> Unit,
    toBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF9FFFF))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                contentDescription = "back button",
                tint = CalmGreen,
                modifier = Modifier.padding(start = 4.dp)
                    .clickable(
                        onClick = toBack
                    )
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "Try Random Journaling",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF238A91),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.help_1),
                contentDescription = "Something Random Icon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        TopicCard(randomViewModel)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = backToNewEntry,
                colors = ButtonDefaults.buttonColors(
                    CalmGreen
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp,
                        spotColor = CalmGreen,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .width(260.dp)
                    .height(40.dp)
            ) {
                Text(text = "Continue Journaling",
                    color = Color.White)
            }
        }
    }
}

@Composable
fun TopicCard(
    randomViewModel: RandomViewModel
) {

    val topicUiState by randomViewModel.uiState.collectAsState()
    val topic: Topic = randomViewModel.getTopic(topicUiState.topicNumber)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 15.dp))
            .padding(15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = topic.imagePath),
                    contentDescription = "Topic Icon",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = topic.description,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .width(260.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = topic.name,
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = CalmGreen,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(size = 15.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Here are some questions to Guide you :",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                ),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = topic.questions,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { randomViewModel.newTopic() },
                colors = ButtonDefaults.buttonColors(
                    CalmGreen
                ),
            ) {
                // change to dice icon
                Text(
                    text = "Randomize Topic",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RandomPreview() {
    RandomView(RandomViewModel(), {}, {})
}