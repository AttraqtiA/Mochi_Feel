package com.example.mochi_feel.data

import android.icu.util.Calendar
import android.util.Log
import com.example.mochi_feel.R
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.model.Tag
import com.example.mochi_feel.model.User
import com.example.mochi_feel.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.Date
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {
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

     fun getUserUID(): String? {
        val result = firebaseAuth.uid
        return firebaseAuth.uid ?: ""
    }

    private suspend fun getUserEmailByUsername(username: String): String? {
        // Assume you have a Firestore query to fetch user data by username
        val querySnapshot = firestore.collection("users")
            .whereEqualTo("username", username)
            .get()
            .await()

        return querySnapshot.documents.firstOrNull()?.getString("email")
    }

     fun addTag(name: String) {
        getUserUID()?.let {
            val userDocumentRef = firestore.collection("users").document(it)

            // Update the "tags" field with the new tag
            userDocumentRef.collection("tags").add(
                "name" to name
            )
        }
    }

    suspend fun addEntries(
        title: String,
        content: String,
        date: Date,
        tagsList: MutableList<Tag>?
    ) {
        getUserUID()?.let {
            val userDocumentRef = firestore.collection("users").document(it)

            val entryData = hashMapOf(
                "title" to title,
                "content" to content,
                "current_date" to Calendar.getInstance().time,
            )
            val entryRef = userDocumentRef.collection("entries").add(entryData).await()
            val entryId = entryRef.id

            // Add tags to the "tags" subcollection of the entry
            if (tagsList != null) {
                for (tag in tagsList) {
                    userDocumentRef
                        .collection("entries")
                        .document(entryId)
                        .collection("tags")
                        .add(hashMapOf("name" to tag.name))
                }
            }
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
                        "date_joined" to Calendar.getInstance().time
                    )
                    //happy, sad, rant
                    firestore.collection("users").document(user.uid)
                        .set(userData)
                    setTags(firestore, user.uid)
                }
            } catch (e: Exception) {
                val errorMessage = e.message ?: "Unknown error"
                emit(Resource.Error(errorMessage))
                // Log the error for debugging purposes
                Log.e("RegistrationError", errorMessage, e)
            }
        }
    }

    private fun setAchievement(firestore: FirebaseFirestore, uid: String) {
        val achievementCollection = firestore.collection("users").document(uid)
            .collection("achievements")
        achievementCollection.add(
            hashMapOf(
                "name" to "1 Year User",
                "image_path" to R.drawable.achievements_1
            )
        )
        achievementCollection.add(
            hashMapOf(
                "name" to "500 Entries",
                "image_path" to R.drawable.achievements_2
            )
        )
        achievementCollection.add(
            hashMapOf(
                "name" to "Have 100+ Tags",
                "image_path" to R.drawable.achievements_3
            )
        )
    }

    private fun setTags(firestore: FirebaseFirestore, uid: String) {
        val tagsCollection = firestore.collection("users").document(uid)
            .collection("tags")
        tagsCollection.add(
            hashMapOf(
                "name" to "Happy"
            )
        )
        tagsCollection.add(
            hashMapOf(
                "name" to "Sad"
            )
        )
        tagsCollection.add(
            hashMapOf(
                "name" to "Rant"
            )
        )
        tagsCollection.add(
            hashMapOf(
                "name" to "Bored"
            )
        )
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

    suspend fun fetchUserData(uid: String): User? {
        val firestore = FirebaseFirestore.getInstance()

        try {
            val documentSnapshot = firestore.collection("users")
                .document(uid)
                .get()
                .await()

            if (documentSnapshot.exists()) {
                // Your existing code to get User data from Firestore
                val userData = documentSnapshot.toObject(User::class.java)

// Convert timestamp to Date for the date_joined field
                val timestamp = documentSnapshot.getTimestamp("date_joined")
                userData?.date_joined = timestamp?.toDate()

                val birthDate = documentSnapshot.getTimestamp("birthDate")
                userData?.birthDate = birthDate?.toDate()

// Get entries subcollection
                val entriesCollection = documentSnapshot.reference.collection("entries")
                val entryList = entriesCollection.get().await().documents.mapNotNull { entryDoc ->
                    val entryTimestamp = entryDoc.getTimestamp("current_date")
                    if (entryTimestamp != null) {
                        val calendar = Calendar.getInstance()
                        calendar.time = entryTimestamp.toDate()

                        val hour = calendar.get(Calendar.HOUR_OF_DAY)
                        val minute = calendar.get(Calendar.MINUTE)

                        EntryBox(
                            title = entryDoc.getString("title") ?: "",
                            entry = entryDoc.getString("content") ?: "",
                            time = "$hour:$minute",
                            current_date = entryTimestamp.toDate()
                        )
                    } else {
                        null
                    }
                }
                userData?.entries = entryList.toMutableList()

                // Get tags subcollection
                val tagsCollection = documentSnapshot.reference.collection("tags")
                val tagList = tagsCollection.get().await().documents.mapNotNull { tagDoc ->
                    tagDoc.getString("name")?.let {
                        Tag(
                            name = it
                        )
                    }
                }
                userData?.tags = tagList.toMutableList()
                return userData
            } else {
                // The document does not exist for the given UID
                return null
            }

        } catch (e: Exception) {
            // Handle exceptions (e.g., network issues, Firestore errors)
            return null
        }
    }
}