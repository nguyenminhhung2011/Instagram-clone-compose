package com.example.abdroidbase.data.model

import com.example.abdroidbase.enum.TypeMessage
import java.util.Date

data class Message(
    val uid1: String,
    val uid2: String,
    val title: String,
    val photoURL: String,
    val typeMessage: TypeMessage,
    val date: Date,
    val messageId: String
)
