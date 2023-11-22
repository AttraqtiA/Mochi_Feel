package com.example.mochi_feel.ui.screen.journalingEntry

import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.ui.screen.components.OneEntryBox
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.inter
import com.example.mochi_feel.viewmodel.Journaling_Entry.HomeViewModel

@Composable
fun HomeView(
    ClickToAddEntry: () -> Unit,

    homeViewModel: HomeViewModel = hiltViewModel()
) {
    homeViewModel.initiate()
    val userData by homeViewModel.userData.collectAsState()

    val entriesData by homeViewModel.entriesData.collectAsState()
    
    val variabel_UIState by homeViewModel.uiState.collectAsState()

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 24.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item(content = {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        text = "Good morning ${userData?.username}!",
                        fontSize = 20.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(700),
                        color = CalmGreen,
                    )
                    Text(
                        text = variabel_UIState.getCurrentDate(),
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(400),
                        color = CalmGreen,
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.homepage),
                    contentDescription = "Mochi at Home",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable(onClick = {
                            Toast
                                .makeText(
                                    context, "Are you feeling better now?", Toast.LENGTH_SHORT
                                )
                                .show()
                        })
                        .width(240.dp)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    Modifier
                        .width(80.dp)
                        .background(
                            color = CalmGreen, shape = RoundedCornerShape(size = 5.dp)
                        ), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${variabel_UIState.streak}",
                        fontSize = 50.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )
                }

                Text(
                    text = "You currently have a journal streak of ${variabel_UIState.streak} days! Keep it up!",
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(500),
                    color = CalmGreen,
                )
            }

        })


        item(content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (onedate in variabel_UIState.FormattedCalendarDisplay()) {
                    if (onedate.date_number.toInt() < variabel_UIState.CurrentDateChecker()
                            .toInt()
                    ) {
                        OneDatePast(onedate.day_name, onedate.date_number)
                    } else if (onedate.date_number.toInt() == variabel_UIState.CurrentDateChecker()
                            .toInt()
                    ) {
                        OneDateActive(onedate.day_name, onedate.date_number)
                    } else {
                        OneDateFuture(onedate.day_name, onedate.date_number)
                    }
                }
            }
            Divider(
                color = CalmGreen,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp)
                    .height(1.dp)
            )

            if (variabel_UIState.EntryBoxList.size == 0) {
                ToAddEntryButton0(ClickToAddEntry)
            } else {
                ToAddEntryButton1(ClickToAddEntry)
            }
        })

        items(entriesData ?: emptyList()) { entrybox: EntryBox ->
            OneEntryBox(
                entrybox.title,
                entrybox.time,
                entrybox.current_date,
                entrybox.tags_list,
                entrybox.entry
            )
        }
    }
}

@Composable
fun OneDateActive(day_name: String, date_number: String) {
    Column(
        Modifier
            .width(32.dp)
            .height(48.dp)
            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 5.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = day_name,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = date_number,
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

@Composable
fun OneDatePast(day_name: String, date_number: String) {
    Column(
        Modifier
            .width(32.dp)
            .height(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = day_name,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(300),
                color = Color(0xFF238A91),
            )
        )
        Text(
            text = date_number,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(500),
                color = Color(0xFF238A91),
            )
        )
    }
}

@Composable
fun OneDateFuture(day_name: String, date_number: String) {
    Column(
        Modifier
            .width(32.dp)
            .height(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = day_name,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(300),
                color = Color(0x4D000000),
            )
        )
        Text(
            text = date_number,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(500),
                color = Color(0x4D000000),
            )
        )
    }
}

@Composable
fun ToAddEntryButton0(ClickToAddEntry: () -> Unit) {
    Button(
        onClick = ClickToAddEntry,
        colors = ButtonDefaults.buttonColors(
            CalmGreen
        ), shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(bottom = 24.dp)
            .shadow(
                elevation = 4.dp,
                spotColor = CalmGreen,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Text(
            text = "+ Start writing your first entry",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .padding(vertical = 4.dp)
        )
    }
}

@Composable
fun ToAddEntryButton1(ClickToAddEntry: () -> Unit) {
    Button(
        onClick = ClickToAddEntry,
        colors = ButtonDefaults.buttonColors(
            Color.White
        ), shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(bottom = 24.dp)
            .shadow(
                elevation = 4.dp,
                spotColor = CalmGreen,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color = CalmGreen,
                shape = RoundedCornerShape(size = 10.dp)
            )
    ) {
        Text(
            text = "+ Write another entry",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(600),
                color = Color(0xFF238A91),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .padding(horizontal = 32.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun HomePreview() {
    HomeView({})
}