package com.example.mochi_feel.ui.screen.journalingEntry

import androidx.compose.foundation.border
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.theme.CalmGreen

@Composable
fun ViewNewEntry(){
    Column(
        modifier = Modifier.fillMaxSize(),
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
                Text(text = "New Entry")
                Icon(
                    painter = painterResource(id = R.drawable.baseline_save_24),
                    contentDescription = "back button",
                    tint = CalmGreen,
                    modifier = Modifier.padding(end = 4.dp))
            }
            Text(
                text = "Current Date, this is just empty text for now",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

//        Add recent tags
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Add recent tags to your Entry")
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Tag1")
                    Text(text = "Tag2")
                    Text(text = "And so on")
                }
            }

//        Add tags
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Add tags")
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Tag1")
                    Text(text = "Tag2")
                    Text(text = "And so on")
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Don't know what to write about?")
                Button(onClick = { /*TODO*/ },)
                 {
                    Text(text = "Let us help",)
                }
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