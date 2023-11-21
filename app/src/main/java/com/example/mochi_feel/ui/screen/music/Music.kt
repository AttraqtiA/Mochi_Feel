package com.example.mochi_feel.ui.screen.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Music
import com.example.mochi_feel.ui.theme.inter

@Composable
fun MusicView(
    musicViewModel: MusicViewModel
) {
    val context = LocalContext.current

    // Initialize the media player when the composable is first composed
    DisposableEffect(Unit) {
        onDispose {
            // Dispose of resources when the composable is disposed
            musicViewModel.stopMusic()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.Center, // Center horizontally
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Playlist",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF238A91),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(start = 32.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.sound_off),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
        }


        ActiveMusic(Music("Halo", "Nyahalo", R.raw.matcha_mochi_cute))
        NotActiveMusic(Music("Halo", "Nyahalo", R.raw.matcha_mochi_cute))

//        LazyColumn {
//            items() {
//
//            }
//        }
    }
}

@Composable
fun ActiveMusic(music: Music) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF238A91))
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .clickable(
                onClick = { MusicViewModel().stopMusic() }
            ),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = music.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                )
            )
            Text(
                text = music.artist,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(400),
                    color = Color.White,
                )
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(4.dp)
                .height(16.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.dots_white),
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
@Composable
fun NotActiveMusic(music: Music) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = music.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF238A91),
                )
            )
            Text(
                text = music.artist,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF238A91),
                )
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(4.dp)
                .height(16.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.dots_green),
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MusicPreview() {
//    MusicView({ })
}