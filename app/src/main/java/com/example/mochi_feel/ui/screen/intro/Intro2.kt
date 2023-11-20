package com.example.mochi_feel.ui.screen.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun ViewIntro2(ButtonClicked: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color.White)
            .padding(top = 80.dp)
            .fillMaxSize()


    ) {
        Text(
            text = "Mochi Feel",
            fontSize = 32.sp,
            color = CalmGreen,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id = R.drawable.intro2),
            contentDescription = "intro 2",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(bottom = 50.dp, top = 64.dp)
                .width(280.dp)
                .height(220.dp)
        )
        CircleProgress(introPage = 2)
        Text(
            text = "Journal Everyday",
            fontSize = 24.sp,
            color = CalmGreen,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
        )
        Text(
            text = "Got a lot of thoughts? Write then down.",
            fontSize = 16.sp,
            color = CalmGreen,
        )
        Button(
            onClick = ButtonClicked, colors = ButtonDefaults.buttonColors(
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
            Text(
                text = "Next",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewIntro2() {
    ViewIntro2({})
}