package com.example.abdroidbase.data.model

import android.os.health.UidHealthStats

data class User (
    val uid: String,
    val password: String,
    val photoUrl: String,
    val bio: String,
    val followers: List<String>,
    val following: List<String>,
    val profile: Int,
    val userName: String,
    val storyCount: Int = 0,
    val description: String,
    val favorite: List<Int>,
)