package com.example.mochi_feel.model

import java.util.Date

data class User(
    val username: String? = null,
    val name: String? = null,
    val email: String? = null,
    var birthDate: Date? = null,
    var date_joined: Date? = null,
    var entries: MutableList<EntryBox>? = null,
    var tags: MutableList<Tag>? = null
)