package com.example.mochi_feel.model

import androidx.annotation.DrawableRes
import kotlin.random.Random

data class TopicUiState (
    var topicNumber:Int = Random.nextInt(1,7)
)

data class Topic (
    var name: String,
    var description: String,
    var questions: String,
    @DrawableRes val imagePath: Int,
)