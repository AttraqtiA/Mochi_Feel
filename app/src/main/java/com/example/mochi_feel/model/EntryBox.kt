package com.example.mochi_feel.model

import java.util.Date

data class EntryBox(
    val title: String,
    val time: String,
    val current_date: Date = Date(),
    val tags: MutableList<Tag> = mutableListOf(Tag(name = "lost hope"), Tag(name = "tired of life")),
    val entry: String
)
