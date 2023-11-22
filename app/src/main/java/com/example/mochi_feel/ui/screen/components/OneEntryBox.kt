package com.example.mochi_feel.ui.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.model.Tag
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.inter
import java.util.Date

@Composable
fun OneEntryBox(
    title: String,
    time: String,
    current_date: Date?,
    tags_list: MutableList<Tag>,
    entry: String,
    toEntryDetail: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
            .background(color = CalmGreen, shape = RoundedCornerShape(size = 10.dp))
            .padding(16.dp)
            .clickable(
                onClick = toEntryDetail
            )
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontFamily = inter,
            fontWeight = FontWeight(600),
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "${time}, ${current_date}",
            fontSize = 12.sp,
            fontFamily = inter,
            fontWeight = FontWeight(500),
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (tags in tags_list) {
                Row(
                    Modifier
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 5.dp)
                        )
                        .padding(start = 5.dp, top = 2.dp, end = 5.dp, bottom = 2.dp)
                ) {
                    Text(
                        text = tags.name,
                        fontSize = 8.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF238A91),
                    )
                }
            }
        }
        Text(
            text = entry,
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = inter,
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}