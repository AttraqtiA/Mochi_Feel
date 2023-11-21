package com.example.mochi_feel.ui.screen.settings

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
import androidx.compose.material3.Icon
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
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.inter

@Composable
fun SettingsView(
    toBack: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(20.dp)

    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
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
            Text(
                text = "Settings",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF238A91),
                    textAlign = TextAlign.Center,
                )
            )
            // so that the title is right in the middle lol
            Icon(
                painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                contentDescription = "blank",
                tint = Color.White,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Column (
            modifier = Modifier
                .padding(28.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image (
                        painter = painterResource(id = R.drawable.settings_account),
                        contentDescription = "Account Icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = "Account",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontFamily = inter,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF238A91),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Image (
                    painter = painterResource(id = R.drawable.settings_nextbutton),
                    contentDescription = "Next Button",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.8.dp)
                    .background(CalmGreen)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp, top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image (
                        painter = painterResource(id = R.drawable.settings_notification),
                        contentDescription = "Notification Icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = "Notifications",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontFamily = inter,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF238A91),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Image (
                    painter = painterResource(id = R.drawable.settings_nextbutton),
                    contentDescription = "Next Button",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.8.dp)
                    .background(CalmGreen)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp, top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image (
                        painter = painterResource(id = R.drawable.settings_appearance),
                        contentDescription = "Appearance Icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = "Appearance",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontFamily = inter,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF238A91),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Image (
                    painter = painterResource(id = R.drawable.settings_nextbutton),
                    contentDescription = "Next Button",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.8.dp)
                    .background(CalmGreen)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp, top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image (
                        painter = painterResource(id = R.drawable.settings_privacy),
                        contentDescription = "Privacy Icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = "Privacy",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontFamily = inter,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF238A91),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Image (
                    painter = painterResource(id = R.drawable.settings_nextbutton),
                    contentDescription = "Next Button",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.8.dp)
                    .background(CalmGreen)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp, top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image (
                        painter = painterResource(id = R.drawable.settings_about),
                        contentDescription = "About Icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = "About",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontFamily = inter,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF238A91),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Image (
                    painter = painterResource(id = R.drawable.settings_nextbutton),
                    contentDescription = "Next Button",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.8.dp)
                    .background(CalmGreen)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsPreview() {
    SettingsView({})
}
