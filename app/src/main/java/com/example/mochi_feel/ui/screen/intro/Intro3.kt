package com.example.mochi_feel.ui.screen.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.theme.CalmGreen

@Composable
fun ViewIntro3() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.CenterVertically)
    ) {
        Text(
            text = "Mochi Feel",
            fontSize = 32.sp,
            color = CalmGreen,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id = R.drawable.intro3),
            contentDescription = "intro 2",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(bottom = 36.dp)
                .width(250.dp)
                .height(250.dp)
        )
        CircleProgress(introPage = 3)
        Text(
            text = "Journal Everyday",
            fontSize = 24.sp,
            color = CalmGreen,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Got a lot of thoughts? Write then down.",
            fontSize = 16.sp,
            color = CalmGreen,
        )
        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                CalmGreen
            ), shape = RoundedCornerShape(10.dp), modifier = Modifier
                .padding(top = 18.dp)
                .shadow(
                    elevation = 8.dp,
                    spotColor = CalmGreen,
                    shape = RoundedCornerShape(10.dp)
                )
                .width(260.dp)
                .height(40.dp)

        ) {
            Text(text = "Login")
        }
        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                CalmGreen
            ), shape = RoundedCornerShape(10.dp), modifier = Modifier
                .padding(top = 6.dp)
                .shadow(
                    elevation = 8.dp,
                    spotColor = CalmGreen,
                    shape = RoundedCornerShape(10.dp)
                )
                .width(260.dp)
                .height(40.dp)

        ) {
            Text(text = "Register")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewIntro3() {
    ViewIntro3()
}