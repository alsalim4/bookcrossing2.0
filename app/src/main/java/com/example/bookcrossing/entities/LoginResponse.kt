package com.example.bookcrossing.entities

import com.google.gson.annotations.SerializedName


data class LoginResponse(
        @SerializedName("code") val code: Int,
        @SerializedName("user") val user: User?
)