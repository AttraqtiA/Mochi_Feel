package com.example.mochi_feel.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

data class HomeUIState (
    val username: String,
    val current_date: Date = Date(),
    val streak: Int,
    val EntryBoxList: MutableList<EntryBox> = mutableListOf()
) {
    @SuppressLint("SimpleDateFormat")
    fun getYear():String{
        val df = SimpleDateFormat("yyyy")
        return df.format(current_date)
    }
}
