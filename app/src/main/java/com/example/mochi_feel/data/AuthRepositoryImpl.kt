package com.example.mochi_feel.data

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
        TODO("Not yet implemented")
    }


//    override fun registerUser(
//        email: String,
//        password: String,
//        username: String,
//        name: String,
//        birthDate: String
//    ): Flow<Resource<AuthResult>> {
//        return flow {
//            emit(Resource.Loading())
//
//            try {
//                // Create a new user with email and password
//                val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
//                emit(Resource.Success(authResult))
//
//                // If user creation is successful, create a new Firestore document for the user
//                val user = authResult.user
//                if (user != null) {
//                    val userData = hashMapOf(
//                        "username" to username,
//                        "name" to name,
//                        "birthDate" to birthDate
//                        // Add more fields as needed
//                    )
//
//                    // Replace "users" with the desired collection name
//                    firestore.collection("users").document(user.uid)
//                        .set(userData)
//                        .addOnFailureListener { e ->
//                            emit(Resource.Error(e.message.toString()))
//                        }
//                }
//            } catch (e: Exception) {
//                // Handle registration failures
//                emit(Resource.Error(e.message.toString()))
//            }
//        }.catch { e ->
//            // Handle exceptions during Firestore operation
//            emit(Resource.Error(e.message.toString()))
//        }
//    }


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