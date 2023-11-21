package com.example.mochi_feel.ui.screen.journalingEntry

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.theme.CalmGreen

@Composable
fun ViewNewEntry(){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
//          purely for the wrapper
            modifier = Modifier.fillMaxWidth(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//        header part
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                    contentDescription = "back button",
                    tint = CalmGreen,
                    modifier = Modifier.padding(start = 4.dp))
                Text(text = "New Entry",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF238A91),

                        textAlign = TextAlign.Center,
                    ))
                Icon(
                    painter = painterResource(id = R.drawable.baseline_save_24),
                    contentDescription = "back button",
                    tint = CalmGreen,
                    modifier = Modifier.padding(end = 4.dp))
            }
            Text(
                text = "Thursday, 12 October",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF238A91),

                    ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

//        Add recent tags
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Add recent tags to your Entry",
                    style = TextStyle(
                        fontSize = 14.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF238A91),

                        ))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Tag1",
                        style = TextStyle(
                            fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                        ),
                        modifier = Modifier
                            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 5.dp))
                            .padding(start = 5.dp, top = 2.dp, end = 5.dp, bottom = 2.dp))
                    Text(text = "Tag2",
                        style = TextStyle(
                            fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF238A91),
                        ),
                        modifier = Modifier
                            .background(color = Color(0xFFEDEDED), shape = RoundedCornerShape(size = 5.dp))
                            .padding(start = 5.dp, top = 2.dp, end = 5.dp, bottom = 2.dp))
                    Text(text = "And so on",
                        style = TextStyle(
                            fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF238A91),
                        ),
                        modifier = Modifier
                            .background(color = Color(0xFFEDEDED), shape = RoundedCornerShape(size = 5.dp))
                            .padding(start = 5.dp, top = 2.dp, end = 5.dp, bottom = 2.dp))
                }
            }

//        Add tags
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Add tags",
                    style = TextStyle(
                        fontSize = 14.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF238A91),

                        ))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Tag1",
                    style = TextStyle(
                        fontSize = 12.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        ),
                    modifier = Modifier
                        .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 5.dp))
                        .padding(start = 6.dp, top = 4.dp, end = 6.dp, bottom = 4.dp)
                    )
                    Text(text = "Tag2",
                        style = TextStyle(
                            fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),

                            ),
                        modifier = Modifier
                            .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 5.dp))
                            .padding(start = 6.dp, top = 4.dp, end = 6.dp, bottom = 4.dp))
                    Text(text = "+ Add Tag",
                        style = TextStyle(
                            fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF238A91),
                            ),
                        modifier = Modifier
                            .border(width = 1.dp, color = Color(0xFF238A91), shape = RoundedCornerShape(size = 5.dp))
                            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 5.dp))
                            .padding(start = 6.dp, top = 4.dp, end = 6.dp, bottom = 4.dp)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Don't know what to write about?",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF238A91),

                        )
                )
                    Text(text = "Let us help",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 21.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),

                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .border(width = 1.dp, color = Color(0xFF238A91), shape = RoundedCornerShape(size = 10.dp))
                            .background(color = Color(0xFF4ABDC0), shape = RoundedCornerShape(size = 10.dp))
                            .padding(start = 6.dp, top = 4.dp, end = 6.dp, bottom = 4.dp)
                            .clickable {  }
                )

            }

            Divider(modifier = Modifier.fillMaxWidth(), color = CalmGreen, thickness = 1.dp)

            Column(
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth()
                    .padding(8.dp),

            ) {
                Text(text = "Start writing here...")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewNewEntry() {
    ViewNewEntry()
}