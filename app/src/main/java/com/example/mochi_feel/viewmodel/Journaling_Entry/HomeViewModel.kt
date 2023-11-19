package com.example.mochi_feel.viewmodel.Journaling_Entry

import androidx.lifecycle.ViewModel
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.model.HomeUIState
import com.example.mochi_feel.model.Tag
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        HomeUIState(
            "Karyna",
            SimpleDateFormat("yyyy-MM-dd").parse("2023-11-23")!!,
            15,
            mutableListOf(
                SimpleDateFormat("yyyy-MM-dd").parse("2023-11-19")!!,
                SimpleDateFormat("yyyy-MM-dd").parse("2023-11-20")!!,
                SimpleDateFormat("yyyy-MM-dd").parse("2023-11-21")!!,
                SimpleDateFormat("yyyy-MM-dd").parse("2023-11-22")!!,
                SimpleDateFormat("yyyy-MM-dd").parse("2023-11-23")!!,
                SimpleDateFormat("yyyy-MM-dd").parse("2023-11-24")!!,
                SimpleDateFormat("yyyy-MM-dd").parse("2023-11-25")!!,
            ),

            mutableListOf(
                EntryBox(
                    "Cake for breakfast",
                    "08.20",
                    SimpleDateFormat("yyyy-MM-dd").parse("2023-11-23")!!,
                    mutableListOf(Tag(name = "lost hope"), Tag(name = "tired of life")),
                    "This morning I came down for breakfast and found a huge strawberry cake on the counter..."
                )
            )
        )
    )
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow() //buat panggil di view

    init {

    }


    fun RestartGame() {

    }
}