package com.example.mochi_feel.data

import android.util.Log
import com.example.mochi_feel.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {

    val firebaseFirestore = FirebaseFirestore.getInstance()
    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }

    }

    override fun registerUser(
        email: String,
        password: String,
        username: String,
        name: String,
        birthDate: String
    ): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            try {
                val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                emit(Resource.Success(result))
                val user = result.user
                if (user != null) {
                    val userData = hashMapOf(
                        "username" to username,
                        "name" to name,
                        "birthDate" to birthDate,
                        "email" to email,
                    )
                    firestore.collection("users").document(user.uid)
                        .set(userData)
                }
            } catch (e: Exception) {
                val errorMessage = e.message ?: "Unknown error"
                emit(Resource.Error(errorMessage))
                // Log the error for debugging purposes
                Log.e("RegistrationError", errorMessage, e)
            }
        }
    }


    override fun googleSignIn(credential: AuthCredential): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithCredential(credential).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }
}