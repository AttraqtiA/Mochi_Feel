package com.example.mochi_feel.ui.screen.journalingEntry

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Tag
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.ui.theme.CalmGreenLight
import com.example.mochi_feel.viewmodel.Journaling_Entry.HomeViewModel
import com.example.mochi_feel.viewmodel.Journaling_Entry.NewEntryViewModel

@SuppressLint("RememberReturnType")
@Composable
fun ViewNewEntry(
    saveNewEntry: () -> Unit,
    toHelpPage: () -> Unit,
    toBack: () -> Unit,
//    newEntryViewModel: NewEntryViewModel = hiltViewModel()
){
//    val entriesData by newEntryViewModel.entriesData.collectAsState()

    val makeTag = remember { mutableStateOf(false) }

    var entryContent by remember { mutableStateOf("") }
    var entryTitle by remember { mutableStateOf("New Entry") }

    val canAdd:Boolean = entryContent.isNotEmpty()

    val tagsList:MutableList<Tag> = mutableListOf(
        Tag(name = "yes"),
        Tag(name = "rant"),
        Tag(name = "yes2"),
        Tag(name = "yes3"),
        Tag(name = "yes4"),
        Tag(name = "tag name thts too long"),
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 12.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
//          purely for the wrapper
            modifier = Modifier.fillMaxWidth(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
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
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable(
                            onClick = toBack
                        ))
                BasicTextField(
                    value = entryTitle,
                    onValueChange = {entryTitle = it},
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF238A91),
                        textAlign = TextAlign.Center,
                    )
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_save_24),
                    contentDescription = "save button",
                    tint = CalmGreen,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .clickable(
                            onClick = saveNewEntry
                        ))
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

//        Add recent tags
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Add recent tags to your Entry",
                    style = TextStyle(
                        fontSize = 14.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF238A91),
                        )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    LazyRow(
                        modifier = Modifier.widthIn(0.dp, 350.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        content = {
                            items(tagsList){tag:Tag ->
                                Text(text = tag.name,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                    ),
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xFF238A91),
                                            shape = RoundedCornerShape(size = 5.dp)
                                        )
                                        .padding(
                                            start = 5.dp,
                                            top = 2.dp,
                                            end = 5.dp,
                                            bottom = 2.dp
                                        )
                                )
                            }
                        }
                    )

                    Text(text = "And so on",
                        style = TextStyle(
                            fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF238A91),
                        ),
                        modifier = Modifier
                            .background(
                                color = Color(0xFFEDEDED),
                                shape = RoundedCornerShape(size = 5.dp)
                            )
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
                        )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    LazyRow(
                        modifier = Modifier.widthIn(0.dp, 350.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        content = {
                            items(tagsList){tag:Tag ->
                                Text(text = tag.name,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFFFFFFF),
                                    ),
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xFF238A91),
                                            shape = RoundedCornerShape(size = 5.dp)
                                        )
                                        .padding(
                                            start = 5.dp,
                                            top = 2.dp,
                                            end = 5.dp,
                                            bottom = 2.dp
                                        )
                                )
                            }
                        }
                    )

                    Text(text = "+ Add Tag",
                        style = TextStyle(
                            fontSize = 12.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF238A91),
                            ),
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFF238A91),
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .padding(start = 6.dp, top = 4.dp, end = 6.dp, bottom = 4.dp)
                            .clickable {
                                makeTag.value = !makeTag.value
                            }
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Don't know what to write about?",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF238A91),
                        ),
                    modifier = Modifier.padding(end = 6.dp)
                )
                    Text(text = "Let us help",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 21.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color.White,

                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = CalmGreen,
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                            .background(
                                color = CalmGreenLight,
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                            .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
                            .clickable(
                                onClick = toHelpPage
                            )
                )

            }

            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp), color = CalmGreen, thickness = 1.dp)

            Box(
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth(0.95f)
                    .padding(8.dp)
                    .border(width = 0.1.dp, color = CalmGreen, shape = RoundedCornerShape(10.dp)),

            ) {
                FloatingActionButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = 8.dp, y = 8.dp)
                        .animateContentSize()
                        .shadow(0.dp, shape = MaterialTheme.shapes.medium),
                    onClick = { if(canAdd){
                        /*TODO*/
//                        insert function to add new entry here
                    } },
                    containerColor = CalmGreenLight,
                    contentColor = CalmGreenLight,
                    shape = RoundedCornerShape(10.dp),
                ) {
                        Text(
                            text = if(canAdd) "+ Add New Entry" else "+",
                            color = Color.White,
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .animateContentSize()
                        )
                }

                BasicTextField(
                    value = entryContent,
                    onValueChange = { entryContent = it },
                    textStyle = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(600),
                        color = CalmGreen,
                    ),
                    modifier = Modifier.padding(8.dp),
                    decorationBox = { innerTextField ->
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)) {
                            if (entryContent.isEmpty()) {
                                Text(text = "Start writing here...",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 21.sp,
                                        fontWeight = FontWeight(600),
                                        color = CalmGreen,
                                    ),
                                    modifier = Modifier.alpha(0.6f)
                                )
                            }
                            innerTextField()  //<-- Add this
                        }
                    }
                )

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewNewEntry() {
    ViewNewEntry({}, {}, {})
}