package com.example.mochi_feel.model

data class LoginState (
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)