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
    override fun loginUser(username: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())

            // Assume you have a function to fetch the user's email from the user collection
            val userEmail = getUserEmailByUsername(username)

            // If the email is found, proceed with Firebase Authentication
            if (userEmail != null) {
                val result = firebaseAuth.signInWithEmailAndPassword(userEmail, password).await()
                emit(Resource.Success(result))
            } else {
                emit(Resource.Error("User not found"))
            }
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

    private suspend fun getUserEmailByUsername(username: String): String? {
        // Assume you have a Firestore query to fetch user data by username
        val querySnapshot = firestore.collection("users")
            .whereEqualTo("username", username)
            .get()
            .await()

        return querySnapshot.documents.firstOrNull()?.getString("email")
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