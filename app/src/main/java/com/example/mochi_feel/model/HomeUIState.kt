package com.example.mochi_feel.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class HomeUIState (
    val username: String,
    var current_date: Date,
    val streak: Int,
    val CalendarDisplay: MutableList<Date> = mutableListOf(),
    val EntryBoxList: MutableList<EntryBox> = mutableListOf()
) {
    @SuppressLint("SimpleDateFormat")
    fun getCurrentDate():String{
        current_date = android.icu.util.Calendar.getInstance().time
        val df = android.icu.text.SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault())
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
