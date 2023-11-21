package com.example.mochi_feel.model

import androidx.annotation.RawRes

data class Music(
    val title: String,
    val artist: String,
    @RawRes val song_path: Int = 0
)
