package com.example.mochi_feel.data

import com.example.mochi_feel.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(
        email: String,
        password: String,
        username: String,
        name: String,
        birthDate: String
    ): Flow<Resource<AuthResult>>

    fun googleSignIn(credential: AuthCredential): Flow<Resource<AuthResult>>


}