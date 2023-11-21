package com.example.mochi_feel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mochi_feel.ui.MochiFeelRoute
import com.example.mochi_feel.ui.screen.music.MusicViewModel
import com.example.mochi_feel.ui.theme.Mochi_FeelTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    public val musicViewModel: MusicViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Locale.setDefault(Locale.US)
        setContent {
            // doesn't work
//            window.statusBarColor = getColor(R.color.calmgreen)
//            window.navigationBarColor = getColor(R.color.calmgreen)
            Mochi_FeelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize().background(color = Color.White),
                    color = Color.White
//                    color = MaterialTheme.colorScheme.background
                ) {
                    MochiFeelRoute()
                }
            }
        }
        musicViewModel.initializeMediaPlayer(this)
        musicViewModel.startMusic()

    }

    override fun onDestroy() {
        super.onDestroy()
        // Ensure you release resources when the activity is destroyed
        musicViewModel.stopMusic()
    }
}

