package com.example.bookcrossing.entities

import com.example.bookcrossing.entities.ChatObject

data class MessageResponse(
    var code: Int?,
    var chat: List<ChatObject>?
)