package com.example.bookcrossing

import com.example.bookcrossing.base.CoroutineProvider
import com.example.bookcrossing.presentation.auth.AuthRepository
import com.example.bookcrossing.presentation.auth.AuthViewModel
import com.example.bookcrossing.presentation.profile.ProfileViewModel
import com.example.bookcrossing.presentation.sample.SampleViewModel
import com.example.fundament.presentation.sample.SampleRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    factory {
        CoroutineProvider()
    }
    single {
        FirebaseDatabase.getInstance().reference
    }

    single{
        FirebaseAuth.getInstance()
    }

    factory {
        SampleRepository(get())
    }


    factory {
        AuthRepository(get())
    }

    viewModel {
        SampleViewModel(get())
    }

    viewModel {
        ProfileViewModel()
    }

    viewModel {
        AuthViewModel(get())
    }
}
