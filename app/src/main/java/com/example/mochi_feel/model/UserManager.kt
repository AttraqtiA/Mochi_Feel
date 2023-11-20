package com.example.mochi_feel.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManager @Inject constructor() {

    private var userUid: String? = null

    fun setUserUid(uid: String) {
        userUid = uid
    }

    fun getUserUid(): String? {
        return userUid
    }
}
