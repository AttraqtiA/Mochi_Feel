package com.example.mochi_feel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mochi_feel.ui.MochiFeelRoute
import com.example.mochi_feel.ui.theme.Mochi_FeelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
    }
}
