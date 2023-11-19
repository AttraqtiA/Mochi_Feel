package com.example.mochi_feel.ui.screen.journalingEntry

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Tag
import com.example.mochi_feel.ui.components.EntryCard
import com.example.mochi_feel.ui.screen.components.OneEntryBox
import com.example.mochi_feel.ui.screen.components.OneEntryBoxDemo
import com.example.mochi_feel.ui.theme.CalmGreen

@Composable
fun ViewEntry(){
    var sortAscend by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.fillMaxWidth(0.9f)){
//            Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Entries")
                Row {
                    Text(text = "Sort by Date")
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .rotate(if (sortAscend) 90f else 270f)
                            .clickable { sortAscend = !sortAscend })
                }
            }

//          Search Bar
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Search",
                    tint = CalmGreen
                )
                Text(text = "Search 'Title'")
            }

//            Filter by tags
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Filter by Tags")
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Tag1")
                    Text(text = "Tag2")
                    Text(text = "And so on")
                }
            }

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), content = {
                items(5){
                    OneEntryBoxDemo(title = "title", time = "current time", current_date = "current date", entry = "This is where the entry goes")
                }
            }
            )
        }
    }
}

//@Composable
//fun EntryCard(){
//    Card(
//        modifier = Modifier.clickable { /*Click to move to entry details*/ }
//    ) {
//        Column {
//            Text(text = "Title")
//            Row {
//                Text(text = "Time")
//                Text(text = ", Date")
//            }
//            Row {
//                Text(text = "Tag 1")
//                Text(text = "Tag 2")
//            }
//            Text(text = "This is gonna be the description that will overflow after 2 lilnes")
//        }
//    }
//}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewEntry(){
    ViewEntry()
}