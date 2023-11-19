package com.example.mochi_feel.model

import androidx.annotation.DrawableRes

data class Achievement(
    val name: String,
    @DrawableRes val image_path: Int = 0,
)
