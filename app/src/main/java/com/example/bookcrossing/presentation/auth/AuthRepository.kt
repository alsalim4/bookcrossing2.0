package com.example.bookcrossing.presentation.auth

import com.example.bookcrossing.entities.AsyncResult
import com.example.bookcrossing.entities.User
import com.example.bookcrossing.extensions.authWithGoogle
import com.example.bookcrossing.extensions.login
import com.example.bookcrossing.extensions.register

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth

class AuthRepository(val auth: FirebaseAuth){

    suspend fun login(username: String, password: String): AsyncResult<User> {
        return auth.login(username, password)
    }
    suspend fun register(user: User): AsyncResult<User> {
        return auth.register(user)
    }

    suspend fun registerWithGoogle(user: User, account: GoogleSignInAccount): AsyncResult<User> {
        return auth.authWithGoogle(user, account)
    }

    suspend fun authWithGoogle(user: User, account: GoogleSignInAccount): AsyncResult<User> {
        return auth.authWithGoogle(user, account)
    }
}