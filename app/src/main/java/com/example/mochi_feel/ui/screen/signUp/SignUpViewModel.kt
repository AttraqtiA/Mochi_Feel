package com.example.mochi_feel.ui.screen.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.mochi_feel.data.AuthRepository
import com.example.mochi_feel.model.SignUpState
import com.example.mochi_feel.ui.MochiFeel_Screen
import com.example.mochi_feel.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val _signUpState  = Channel<SignUpState>()
    val signUpState  = _signUpState.receiveAsFlow()


    fun registerUser(
        email: String,
        password: String,
        username:String,
        name:String,
        birthDay: String,
        birthMonth: String,
        birthYear: String,
        navController: NavController
    ) = viewModelScope.launch {
        val birthDate = "$birthDay-$birthMonth-$birthYear"

        repository.registerUser(email, password, username, name, birthDate).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _signUpState.send(SignUpState(isSuccess = "Sign Up Success "))
                    navController.navigate(MochiFeel_Screen.Login.name)
                }
                is Resource.Loading -> {
                    _signUpState.send(SignUpState(isLoading = true))
                }
                is Resource.Error -> {
                    _signUpState.send(SignUpState(isError = result.message))
                }
            }
        }
    }

}