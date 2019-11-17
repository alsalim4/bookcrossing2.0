package com.example.bookcrossing.presentation.auth

import android.content.SharedPreferences
import com.example.bookcrossing.App
import com.example.bookcrossing.entities.AsyncResult
import com.example.bookcrossing.entities.User
import com.example.bookcrossing.extensions.authWithGoogle
import com.example.bookcrossing.extensions.login
import com.example.bookcrossing.extensions.register

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.gson.Gson

const val USER_LOGGED = "user_logged"
const val USER_FIREBASE = "user_firebase"

class AuthRepository(val auth: FirebaseAuth, val sharedPref: SharedPreferences){

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

    fun isUserLogged(): Boolean {
        if (!sharedPref.getBoolean(USER_LOGGED, false)) return false

        val firebaseUser = sharedPref.getString(USER_FIREBASE, "")
        if (firebaseUser == "" || firebaseUser == null) {

            return false
        }

        val user = Gson().fromJson(firebaseUser, User::class.java)
        App.user = user
        return true
    }

    fun saveUser() {
        sharedPref.edit().putBoolean(USER_LOGGED, true).apply()
        val json = Gson().toJson(App.user)
        sharedPref.edit().putString(USER_FIREBASE, json).apply()
    }
    fun logoutUser(){
        sharedPref.edit().putBoolean(USER_LOGGED,false).apply()
    }

}