package com.example.mochi_feel.ui.screen.help

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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

// might change to showing the step 1 by 1
@Composable
fun EmotionView(
    backToNewEntry: () -> Unit,
    toBack: () -> Unit
) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF9FFFF))
            .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 0.dp)
    ) {
        item {
            Row (
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
        }

        item {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Try Reflecting Journaling",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF238A91),
                        textAlign = TextAlign.Center,
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.help_2),
                    contentDescription = "Something Random Icon",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                        .rotate(15f)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Step1Box()
            Spacer(modifier = Modifier.height(16.dp))

        }

        item {
            Step2Box()
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Step3Box()
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row (
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 24.dp),
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
}

@Composable
fun Step1Box() {
    Box (
        modifier = Modifier
            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 15.dp))
            .padding(20.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text (
                text = "Step 1 : Identify Your Feelings",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text (
                text = "Write what you’re feeling without judging or censoring. You may want to think of yourself as a reporter or someone without any personal attachment to the situation. You don’t need to justify your feelings during this step, either. If you’re angry, write about how it feels to be angry. No explanations are necessary.",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                )
            )
        }
    }
}

@Composable
fun Step2Box() {
    Box (
        modifier = Modifier
            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 15.dp))
            .padding(20.dp)
    ) {
        Column (

        ) {
            Text (
                text = "Step 2: Think and Write\nabout the Triggers",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Start,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "After you’ve expressed yourself, see if you can identify the event, person, or situation that triggered your feelings. Did you skip breakfast that day, or was it raining? Does a particular coworker always rub you the wrong way, or did you get angry because you were embarrassed about something?\nTry to be honest about your triggers. They don’t have to make sense. The point of Step 2 is simply to recognize them.",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                )
            )
        }
    }
}

@Composable
fun Step3Box() {
    Box (
        modifier = Modifier
            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 15.dp))
            .padding(20.dp)
    ) {
        Column (

        ) {
            Text (
                text = "Step 3: Explore Your Emotions",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Start,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Now it’s time to try to learn about your emotions, how frequently you respond in this way, and what other options were available in the given situation.\nDuring this step, ask yourself a series of questions, such as:\nWas this a positive or negative experience?\nHave I felt this feeling before, and when?\nWhat could I have done differently during this experience?\nWhy did I react that way?",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmotionPreview() {
    EmotionView({}, {})
}
