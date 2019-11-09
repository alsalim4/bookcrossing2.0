package com.example.bookcrossing.presentation.auth

import androidx.lifecycle.MutableLiveData
import com.example.bookcrossing.base.BaseViewModel
import com.example.bookcrossing.entities.User
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class AuthViewModel(val repository: AuthRepository): BaseViewModel(){


    val registrationLiveData = MutableLiveData<String>()

    fun register(name: String, username: String, password: String) {
        makeRequest({ repository.register(User(name, username, password)) }) { res ->
            unwrap(res) {
                registrationLiveData.value = "Вы успешно зарегистрировались ${it.name}!"
            }
        }
    }

    fun registerWithGoogle(account: GoogleSignInAccount) {
        makeRequest({repository.registerWithGoogle(User(account.displayName, account.email, account.id), account)}){ res->
            unwrap(res){
                registrationLiveData.value = "Вы успешно зарегистрировались ${it.name}!"
            }
        }
    }

    val loginLiveData = MutableLiveData<String>()

    fun login(username: String, password: String) {
        makeRequest({repository.login(username, password)}){ res->
            unwrap(res){
                loginLiveData.value = "Вы успешно авторизовались ${it.name}!"
            }
        }
    }

    fun authWithGoogle(account: GoogleSignInAccount) {
        makeRequest({repository.authWithGoogle(User(account.displayName, account.email, account.id), account)}){ res->
            unwrap(res){
                loginLiveData.value = "Вы успешно авторизовались ${it.name}!"
            }
        }
    }
}