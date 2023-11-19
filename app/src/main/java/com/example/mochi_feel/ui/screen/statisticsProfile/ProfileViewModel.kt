package com.example.mochi_feel.ui.screen.statisticsProfile

import androidx.lifecycle.ViewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Achievement
import com.example.mochi_feel.model.ProfileUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        ProfileUIState(
            "Karyna Budi",
            "Journaling as an escape",
            SimpleDateFormat("yyyy-MM-dd").parse("2022-04-14")!!,
            SimpleDateFormat("yyyy-MM-dd").parse("2004-06-01")!!,
            33, "September", 48, 321,

            mutableListOf("late night", "brain fart", "rants"),
            mutableListOf(98, 130, 56),

            503, 11, 234,

            mutableListOf(
                Achievement("1 Year User", R.drawable.achievements_1),
                Achievement("500 Entries Written", R.drawable.achievements_2),
                Achievement("Have Over 100+ Tags", R.drawable.achievements_3)
            )
        )
    )
    val uiState: StateFlow<ProfileUIState> = _uiState.asStateFlow()


}