package com.example.mochi_feel.ui.screen.journalingEntry

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.model.Tag
import com.example.mochi_feel.ui.screen.components.OneEntryBox
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.viewmodel.Journaling_Entry.EntryListViewModel

@Composable
fun ViewEntry(
//    uid: Int,
    toEntryDetail: (uid:String) -> Unit,
    viewModel: EntryListViewModel = hiltViewModel()
) {
    viewModel.initiate()

    val tagSelectedText = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFFEDEDED),
    )
    val tagSelectedModifier = Modifier
        .background(
            color = CalmGreen,
            shape = RoundedCornerShape(size = 5.dp)
        )
        .padding(
            start = 5.dp,
            top = 2.dp,
            end = 5.dp,
            bottom = 2.dp
        )

    val tagUnselectedText = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(700),
        color = CalmGreen,
    )
    val tagUnselectedModifier = Modifier
        .background(
            color = Color(0xFFEDEDED),
            shape = RoundedCornerShape(size = 5.dp)
        )
        .padding(
            start = 5.dp,
            top = 2.dp,
            end = 5.dp,
            bottom = 2.dp
        )

    var selectedTags by remember { mutableStateOf(viewModel.selectedTags) }

    val userData by viewModel.userData.collectAsState()
    val entriesData by viewModel.entriesData.collectAsState()

    var sortAscend by remember { mutableStateOf(false) }
    if (sortAscend) {
        viewModel.sortDateAscending()
    }
    var searchFilter by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
//            Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Entries",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF238A91),

                        )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Sort by Date",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 21.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF238A91),

                            )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                        contentDescription = "Arrow",
                        tint = CalmGreen,
                        modifier = Modifier
                            .rotate(if (sortAscend) 90f else 270f)
                            .clickable { sortAscend = !sortAscend })
                }
            }

//          Search Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color(0xFF238A91),
                        shape = RoundedCornerShape(size = 20.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Search",
                    tint = CalmGreen,
                    modifier = Modifier.padding(4.dp)
                )

                BasicTextField(
                    value = searchFilter,
                    onValueChange = { searchFilter = it },
                    modifier = Modifier.padding(8.dp),
                    maxLines = 1,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            if (searchFilter.isEmpty()) {
                                Text(
                                    text = "Search 'Title'",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(600),
                                        color = Color(0x80238A91),
                                    ),
                                    modifier = Modifier.alpha(0.6f)
                                )
                            }
                            innerTextField()  //<-- Add this
                        }
                    }
                )
            }

//            Filter by tags
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Filter by Tags",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF238A91),

                        )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        content = {
//                            items(tagsList){tag:Tag ->
                            items(userData?.tags.orEmpty()) { tag: Tag ->
                                Text(
                                    text = tag.name,
                                    style = if (tag in selectedTags) tagSelectedText else tagUnselectedText,
                                    modifier = if (tag in selectedTags) {
                                        tagSelectedModifier
                                            .clickable { selectedTags.remove(tag) }
                                    } else {
                                        tagUnselectedModifier
                                            .clickable { selectedTags.add(tag) }
                                    },
                                )
                            }
                        }
                    )
                }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxHeight()
                ) {
                    items(entriesData ?: emptyList()) { entrybox: EntryBox ->
                        if (entrybox.title.uppercase().contains(searchFilter.uppercase()) ||
                            entrybox.entry.uppercase().contains(searchFilter.uppercase())
                        ) {
                            OneEntryBox(
                                entrybox.title,
                                entrybox.time,
                                entrybox.current_date,
                                entrybox.tags_list,
                                entrybox.entry,
//                            { toEntryDetail(uid) }
                                { toEntryDetail(0.toString()) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewEntry() {
    ViewEntry({})
}