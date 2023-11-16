package com.example.mochi_feel.model

import java.util.Date

data class HomeUIState (
    val username: String,
    val current_date: Date,
    val streak: Int,
    val EntryBoxList: MutableList<EntryBox> = mutableListOf()
) {

}
