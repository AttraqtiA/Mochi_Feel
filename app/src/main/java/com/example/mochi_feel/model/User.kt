package com.example.mochi_feel.model

import java.util.Date

data class User(
    val username: String? = null,
    val name: String? = null,
    val email: String? = null,
    val birthDate: String? = null,
    var date_joined: Date? = null,
    val entries: MutableList<EntryBox>? = null,
    val tags: MutableList<String>? = null
)