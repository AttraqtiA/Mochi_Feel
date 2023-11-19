package com.example.mochi_feel.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

data class ProfileUIState(
    val name: String,
    val bio: String,
    val joinDate: Date = Date(),
    val birthDate: Date =  Date(),

    val averageEntries: Int,
    val peakMonth: String,
    val peakEntries: Int,
    val totalEntry2023: Int,

    val Top3Categories_name: MutableList<String>,
    val Top3Categories_entries: MutableList<Int>,

    val TotalEntries: Int,
    val currentStreak: Int,
    val longestStreak: Int,

    val Achievement_List: MutableList<Achievement>

) {
    @SuppressLint("SimpleDateFormat")
    fun getJoinDate():String{
        val df = SimpleDateFormat("dd MMMM yyyy")
        return df.format(joinDate)
    }

    @SuppressLint("SimpleDateFormat")
    fun getBirthDate():String{
        val df = SimpleDateFormat("dd MMMM yyyy")
        return df.format(birthDate)
    }
}
