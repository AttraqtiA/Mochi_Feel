package com.example.mochi_feel.ui.screen.statisticsProfile

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mochi_feel.R

// still need to wait for the database (?)
// i can just use dummy data for now, database tinggal input ke viewModel - Gavin

@Composable
fun ViewProfile(){
    val name = "Karyna Budi"
    val bio = "Journaling as an escape"
    val joinDate = "14th April 2022"
    val birthDate = "1st June 2004"

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
//            Name and Gear Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text( text = "Profile")
                    Text(text = name)
                }
                Icon(
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = "Settings icon",
                    tint = Color.Black
                )
            }

//        Bio and Short Stats
            Text(text = bio)

            Row (
                modifier = Modifier.fillMaxWidth(),
                
            ){
                InfoCard(
                    name = "Joined",
                    content = joinDate,
                    icon = R.drawable.baseline_person_add_24
                )
                InfoCard(
                    name = "Birthday",
                    content = birthDate,
                    icon = R.drawable.baseline_person_add_24
                )
            }
        }
    }
}

@Composable
fun InfoCard(
    name:String,
    content:String,
    icon:Int
){
    Card {
        Column {
            Row {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Icon Image",
                    tint = Color.White
                )
                Text(text = name)
            }
            Text(text = content)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewProfile(){
    ViewProfile()
}