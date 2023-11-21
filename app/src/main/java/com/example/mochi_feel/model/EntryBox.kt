package com.example.mochi_feel.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

data class EntryBox(
    val title: String,
    val time: String,
    val current_date: Date? = Date(),
    val tags_list: MutableList<Tag> = mutableListOf(Tag(name = "lost hope"), Tag(name = "tired of life")),
    val entry: String
) {
    @SuppressLint("SimpleDateFormat")
    fun getEntryBoxDate():String{
        val df = SimpleDateFormat("EEE, dd MMMM yyyy")
        return df.format(current_date)
    }

    @SuppressLint("SimpleDateFormat")
    fun getEntryBoxDate(date:Date?):String{
        val df = SimpleDateFormat("EEE, dd MMMM yyyy")
        return df.format(date)
    }
}
