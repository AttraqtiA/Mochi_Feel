package com.example.mochi_feel.viewmodel.Journaling_Entry

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mochi_feel.data.AuthRepository
import com.example.mochi_feel.data.AuthRepositoryImpl
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.model.HomeUIState
import com.example.mochi_feel.model.Tag
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
class HomeViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {

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


    fun RestartGame() {

    }
}