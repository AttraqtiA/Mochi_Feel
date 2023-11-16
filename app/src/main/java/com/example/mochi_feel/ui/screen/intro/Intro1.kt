package com.example.mochi_feel.ui.screen.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.GreyDisable

@Composable
fun ViewIntro1() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(id = R.drawable.intro1),
            contentDescription = "intro 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(bottom = 36.dp)
                .width(208.04251.dp)
                .height(176.86874.dp)
        )
        CircleProgress(introPage = 1)
        Text(
            text = "Welcome to Mochi Feel",
            fontSize = 24.sp,
            color = CalmGreen,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Where Every Emotion Has a Story",
            fontSize = 16.sp,
            color = CalmGreen,
        )
        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                CalmGreen
            ), shape = RoundedCornerShape(10.dp), modifier = Modifier
                .padding(top = 64.dp)
                .shadow(
                    elevation = 8.dp,
                    spotColor = CalmGreen,
                    shape = RoundedCornerShape(10.dp)
                )
                .width(260.dp)
                .height(40.dp)

        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun CircleProgress(introPage: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        Box(
            modifier = Modifier
                .background(
                    if (introPage == 1) {
                        CalmGreen
                    } else {
                        GreyDisable
                    }, shape = RoundedCornerShape(100)
                )
                .size(15.dp, 15.dp)
        )
        Box(
            modifier = Modifier
                .background(
                    if (introPage == 2) {
                        CalmGreen
                    } else {
                        GreyDisable
                    }, shape = RoundedCornerShape(100)
                )
                .size(15.dp, 15.dp)
        )
        Box(
            modifier = Modifier
                .background(
                    if (introPage == 3) {
                        CalmGreen
                    } else {
                        GreyDisable
                    }, shape = RoundedCornerShape(100)
                )
                .size(15.dp, 15.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewIntro1() {
    ViewIntro1()
}