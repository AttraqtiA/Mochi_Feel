package com.example.mochi_feel.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

data class HomeUIState (
    val username: String,
    val current_date: Date,
    val streak: Int,
    val CalendarDisplay: MutableList<Date> = mutableListOf(),
    val EntryBoxList: MutableList<EntryBox> = mutableListOf()
) {
    @SuppressLint("SimpleDateFormat")
    fun getCurrentDate():String{
        val df = SimpleDateFormat("EEE, dd MMMM yyyy")
        return df.format(current_date)
    }

    @SuppressLint("SimpleDateFormat")
    fun CurrentDateChecker():String{
        val df = SimpleDateFormat("dd")
        return df.format(current_date)
    }

    @SuppressLint("SimpleDateFormat")
    fun FormattedCalendarDisplay():MutableList<Calendar> {
        val df_day = SimpleDateFormat("EEE")
        val df_date = SimpleDateFormat("dd")

        val FormattedCalendar: MutableList<Calendar> = mutableListOf()

        for (onedate in CalendarDisplay) {
            var dayName = df_day.format(onedate)
            var dateNumber = df_date.format(onedate)
            FormattedCalendar.add(Calendar(dayName, dateNumber))
        }

        return FormattedCalendar
    }
}
