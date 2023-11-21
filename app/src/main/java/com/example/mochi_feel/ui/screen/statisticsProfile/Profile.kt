package com.example.mochi_feel.ui.screen.statisticsProfile

import android.annotation.SuppressLint
import android.icu.util.Calendar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Achievement
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.CalmGreenLight
import com.example.mochi_feel.ui.theme.inter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// still need to wait for the database (?)
// i can just use dummy data for now, database tinggal input ke viewModel - Gavin

@Composable
fun ViewProfile(
    toSettings: () -> Unit,

    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    profileViewModel.initiate()
    val userData by profileViewModel.userData.collectAsState()
    val variabel_UIState by profileViewModel.uiState.collectAsState()

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
                        userData?.name?.let {
                            Text(
                                text = it,
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    lineHeight = 21.sp,
                                    fontFamily = inter,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                        }

                    }
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_settings_24),
                        contentDescription = "Settings icon",
                        tint = Color.White,
                        modifier = Modifier
                            .clickable(
                                onClick = toSettings
                            )
                            .size(32.dp)
                    )
                }

                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = variabel_UIState.bio,
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
                        content = formatDate(userData?.date_joined),
                        icon = R.drawable.profile_join_icon
                    )
                    InfoCard(
                        name = "Birthday",
                        content = formatDate(userData?.birthDate),
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
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        ) {
                            append("${variabel_UIState.averageEntries}")
                        }
                        append(" entries a month,\nand peaked on ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        ) {
                            append(variabel_UIState.peakMonth)
                        }
                        append(" with ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        ) {
                            append("${variabel_UIState.peakEntries}")
                        }
                        append(" entries.\nYour total entry on 2023 is ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        ) {
                            append("${variabel_UIState.totalEntry2023}")
                        }
                        append(", way to go!")
                    },
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(400),
                        color = CalmGreen,
                    )
                )

                StatisticsTitle("Your Top 3 Categories", Modifier.padding(top = 16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    for (a in 0 until 3) {
                        OneCategory(
                            variabel_UIState.Top3Categories_name.get(a),
                            variabel_UIState.Top3Categories_entries.get(a)
                        )
                    }
                }

                StatisticsTitle("Your Streak Statistics", Modifier.padding(top = 16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OneStatisticBox("Total Entries", variabel_UIState.TotalEntries)
                    OneStatisticBox("Current Streak", variabel_UIState.currentStreak)
                    OneStatisticBox("Longest Streak", variabel_UIState.longestStreak)
                }

                StatisticsTitle("Your Achievements & Badges", Modifier.padding(top = 16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (achievements in variabel_UIState.Achievement_List) {
                        OneAchievementBox(achievementToDisplay = achievements)
                    }
                }
            }

        })

    }
}

@Composable
fun OneAchievementBox(achievementToDisplay: Achievement) {
    Column(
        Modifier
            .background(
                color = Color(0xFF238A91),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(8.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = achievementToDisplay.image_path),
            contentDescription = "Badges",
            modifier = Modifier.size(80.dp)
        )
        Text(
            text = achievementToDisplay.name,
            style = TextStyle(
                fontSize = 10.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            )
        )
    }
}

@SuppressLint("SimpleDateFormat")
fun formatDate(date: Date?):String{
    return if (date != null) {
        val df = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        df.format(date)
    } else {
        // Handle the case when date is null (return an empty string or another default value)
        ""
    }
}

@Composable
fun OneStatisticBox(streakName: String, dataToDisplay: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.border(
            width = 1.dp,
            color = CalmGreen,
            shape = RoundedCornerShape(size = 10.dp)
        )
    ) {
        Row(
            Modifier
                .background(
                    color = Color(0xFF238A91),
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                )
                .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
        ) {
            Text(
                text = streakName,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(4.dp)
            )
        }
        Column(
            modifier = Modifier.padding(bottom = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${dataToDisplay}",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF238A91),
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = "days",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF238A91),
                )
            )

        }
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
            fontWeight = FontWeight.Bold,
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
    ViewProfile({})
}