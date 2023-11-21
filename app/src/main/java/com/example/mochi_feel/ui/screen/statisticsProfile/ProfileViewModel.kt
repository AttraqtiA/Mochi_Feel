package com.example.mochi_feel.ui.screen.statisticsProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mochi_feel.R
import com.example.mochi_feel.data.AuthRepositoryImpl
import com.example.mochi_feel.model.Achievement
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.model.ProfileUIState
import com.example.mochi_feel.model.User
import com.example.mochi_feel.model.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
): ViewModel() {
    private val _userData = MutableStateFlow<User?>(null)

    val userData: StateFlow<User?> = _userData

    @Inject
    lateinit var userManager: UserManager

    fun initiate() {
        val uidrepo = repository.getUserUID()
        if (uidrepo != null) {
            userManager.setUserUid(uidrepo)
        }
        val uid = userManager.getUserUid()

        if (uid != null) {
            fetchUserData(uid)
        }
    }

    fun fetchUserData(uid: String) {
        viewModelScope.launch {
            val result = repository.fetchUserData(uid)
            _userData.value = result
        }
    }
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
                Achievement("500 Entries", R.drawable.achievements_2),
                Achievement("Have 100+ Tags", R.drawable.achievements_3)
            )
        )
    )
    val uiState: StateFlow<ProfileUIState> = _uiState.asStateFlow()


}