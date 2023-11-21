package com.example.mochi_feel.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.mochi_feel.data.AuthRepository
import com.example.mochi_feel.data.AuthRepositoryImpl
import com.example.mochi_feel.model.LoginState
import com.example.mochi_feel.model.User
import com.example.mochi_feel.model.UserManager
import com.example.mochi_feel.ui.MochiFeel_Screen
import com.example.mochi_feel.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {


    private val _userData = MutableStateFlow<User?>(null)
    val userData: StateFlow<User?> = _userData

    @Inject
    lateinit var userManager: UserManager
    // Function to fetch user data based on UID
    fun fetchUserData(uid: String) {
        viewModelScope.launch {
            val result = repository.fetchUserData(uid)
            _userData.value = result
        }
    }
    val _signInState = Channel<LoginState>()
    val signInState = _signInState.receiveAsFlow()

    fun loginUser(username: String, password: String, navController: NavController) = viewModelScope.launch {
        repository.loginUser(username, password).collect { result ->
            when (result) {
                is Resource.Success -> {
                    repository.getUserUID()?.let { userManager.setUserUid(it) }
                    _signInState.send(LoginState(isSuccess = "Sign In Success "))
                    navController.navigate(MochiFeel_Screen.Home.name)
                }
                is Resource.Loading -> {
                    _signInState.send(LoginState(isLoading = true))
                }
                is Resource.Error -> {
                    _signInState.send(LoginState(isError = result.message))
                }
            }
        }
    }
}