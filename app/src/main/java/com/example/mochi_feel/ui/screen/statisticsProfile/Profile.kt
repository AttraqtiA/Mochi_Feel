package com.example.mochi_feel.ui.screen.statisticsProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.CalmGreenLight
import com.example.mochi_feel.ui.theme.inter

// still need to wait for the database (?)
// i can just use dummy data for now, database tinggal input ke viewModel - Gavin

@Composable
fun ViewProfile() {
    val name = "Karyna Budi"
    val bio = "Journaling as an escape"
    val joinDate = "14th April 2022"
    val birthDate = "1st June 2004"

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(CalmGreenLight),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item(content = {
            Column(
                modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Profile",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 21.sp,
                                fontFamily = inter,
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                        Text(
                            text = name,
                            style = TextStyle(
                                fontSize = 24.sp,
                                lineHeight = 21.sp,
                                fontFamily = inter,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                            )
                        )

                    }
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_settings_24),
                        contentDescription = "Settings icon",
                        tint = Color.White,
                        modifier = Modifier
                            .clickable(onClick = {

                            })
                            .size(32.dp)
                    )
                }

                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Journalling as an escape",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                            fontFamily = inter,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 48.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    InfoCard(
                        name = "Joined",
                        content = joinDate,
                        icon = R.drawable.profile_join_icon
                    )
                    InfoCard(
                        name = "Birthday",
                        content = birthDate,
                        icon = R.drawable.profile_birthday_icon
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                    )
                    .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                StatisticsTitle("Your Entry Journey 2023")

                Image(
                    painter = painterResource(id = R.drawable.statistic_dummy),
                    contentDescription = "Statistics",
                    modifier = Modifier
                        .width(320.dp)
                        .height(200.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        append("You averaged ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
                            append("33")
                        }
                        append(" entries a month,\nand peaked on ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
                            append("September")
                        }
                        append(" with ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
                            append("48")
                        }
                        append(" entries.\nYour total entry on 2023 is ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
                            append("321")
                        }
                        append(", way to go!")
                    },
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF238A91),
                    )
                )

                StatisticsTitle("Your Top 3 Categories", Modifier.padding(top = 16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    OneCategory("late night", 98)
                    OneCategory("brain fart", 130)
                    OneCategory("rants", 56)
                }

                StatisticsTitle("Your Streak Statistics", Modifier.padding(top = 16.dp))

            }

        })

    }
}

@Composable
fun StatisticsTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 21.sp,
            fontFamily = inter,
            fontWeight = FontWeight(600),
            color = CalmGreen,
        ),
        modifier = modifier
    )
}
@Composable
fun InfoCard(
    name: String,
    content: String,
    icon: Int
) {
    Row(
        Modifier
            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 10.dp))
            .padding(top = 8.dp, start = 8.dp, end = 24.dp, bottom = 8.dp)
    ) {
        Column {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "Info Card",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
            Text(
                text = content,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                )
            )
        }
    }
}

@Composable
fun OneCategory(category_name: String, category_count: Int) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = category_name,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(700),
                color = Color(0xFF238A91),
                textAlign = TextAlign.Center,
            )
        )
        Column(
            Modifier
                .width(60.dp)
                .height(category_count.dp)
                .background(color = Color(0xFF4ABDC0))
        ) {
            // apa hayoo
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewProfile() {
    ViewProfile()
}