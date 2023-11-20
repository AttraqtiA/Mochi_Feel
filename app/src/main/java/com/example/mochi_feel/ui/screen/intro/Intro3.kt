package com.example.mochi_feel.ui.screen.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.mochi_feel.ui.theme.GreyDisable
import com.example.mochi_feel.ui.theme.inter

@Composable
fun ViewIntro3(LoginClicked: () -> Unit, RegisterClicked: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .fillMaxWidth()
            .padding(top = 80.dp)


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
                .padding(bottom = 30.dp, top = 24.dp)
                .width(270.dp)
                .height(280.dp)
        )
        CircleProgress(introPage = 3)
        Text(
            text = "Explore Your Progress",
            fontSize = 24.sp,
            color = CalmGreen,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
        )
        Text(
            text = "Collect Badges and Unlock Achievements in Your Profile!",
            fontSize = 16.sp,
            color = CalmGreen,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 48.dp)
        )
        Button(
            onClick = LoginClicked, colors = ButtonDefaults.buttonColors(
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
            Text(
                text = "Login",
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
        Button(
            onClick = RegisterClicked, colors = ButtonDefaults.buttonColors(
                containerColor = GreyDisable,
                contentColor = CalmGreen
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
            Text(
                text = "Register",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF238A91),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewIntro3() {
    ViewIntro3({}, {})
}