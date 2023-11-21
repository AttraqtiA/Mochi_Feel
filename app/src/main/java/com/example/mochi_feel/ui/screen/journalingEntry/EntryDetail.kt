package com.example.mochi_feel.ui.screen.journalingEntry


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.theme.CalmGreen

@Composable
fun ViewEntryDetail(){
    val entryTitle = "Cake for Breakfast"
    val entryTime = "08:20, Wednesday 11 October 2023"
    val entryContent = "This morning I came down for breakfast and found a huge strawberry cake on the counter. My mom told me it was a gift from the Hudsons. Apparently they are giving out strawberry cake for the whole neighborhood as a celebration on their newborn niece.\n" +
            "\n" +
            "But why do they waste time and money to share it with the whole neighborhood? Do they feel so much joy that they felt the need to spread joy to everyone around them?\n" +
            "I want to feel that kind of joy too someday."

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.9f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                contentDescription = "Return",
                tint = CalmGreen,
                modifier = Modifier.align(Alignment.Start))

            Column(
                modifier = Modifier.fillMaxWidth(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp, top = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column {
                        Text(text = entryTitle,
                            style = TextStyle(
                                fontSize = 16.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF238A91),
                            )
                        )
                        Text(text = entryTime,
                            style = TextStyle(
                                fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF238A91),
                            )
                        )
                    }
                    Text(text = "edit",
                        style = TextStyle(
                            fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF238A91),
                        ),
                        modifier = Modifier
                            .clickable {  }
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Text(text = "Tag1",
                        style = TextStyle(
                            fontSize = 8.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            ),
                        modifier = Modifier
                            .background(
                                color = Color(0xFF238A91),
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .padding(start = 5.dp, top = 2.dp, end = 5.dp, bottom = 2.dp))
                    Text(text = "Tag2",
                        style = TextStyle(
                            fontSize = 8.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            ),
                        modifier = Modifier
                            .background(
                                color = Color(0xFF238A91),
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .padding(start = 5.dp, top = 2.dp, end = 5.dp, bottom = 2.dp))
                }

                Text(text = entryContent,
                    style = TextStyle(
                        fontSize = 14.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF238A91),
                    )
                )
            }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewEntryDetail(){
    ViewEntryDetail()
}