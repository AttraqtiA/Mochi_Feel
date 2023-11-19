package com.example.mochi_feel.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

data class HomeUIState (
    val username: String,
    val current_date: Date,
    val streak: Int,
    val EntryBoxList: MutableList<EntryBox> = mutableListOf()
) {
    @SuppressLint("SimpleDateFormat")
    fun getCurrentDate():String{
        val df = SimpleDateFormat("EEE, dd MMMM yyyy")
        return df.format(current_date)
    }
}
