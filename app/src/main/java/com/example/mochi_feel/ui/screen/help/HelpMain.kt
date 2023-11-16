package com.example.mochi_feel.ui.screen.help

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontFamily
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (

        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                contentDescription = "back button",
                tint = CalmGreen,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Text (
            text = "What are you thinking of writing about?"
        )
        Box (
            modifier = Modifier
                .shadow(
                    elevation = 30.dp,
                    spotColor = Color(0x4D238A91),
                    ambientColor = Color(0x4D238A91)
                )
                .width(148.dp)
                .height(148.dp)
                .background(color = Color(0xFF4ABDC0), shape = RoundedCornerShape(size = 10.dp))
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.help_1),
                    contentDescription = "Something Random Icon",
                    modifier = Modifier
                        .width(84.dp)
                        .height(84.dp)
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
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HelpMainPreview() {
    HelpMainView()
}