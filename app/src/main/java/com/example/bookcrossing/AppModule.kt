package com.example.bookcrossing

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.media.MediaCodec.MetricsConstants.MODE
import com.example.bookcrossing.base.CoroutineProvider
import com.example.bookcrossing.presentation.auth.AuthRepository
import com.example.bookcrossing.presentation.auth.AuthViewModel
import com.example.bookcrossing.presentation.book.HomeViewModel
import com.example.bookcrossing.presentation.profile.ProfileViewModel
import com.example.bookcrossing.presentation.sample.SampleViewModel
import com.example.fundament.presentation.sample.SampleRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.koin.android.ext.koin.androidContext
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

    single {
        androidContext().getSharedPreferences("APP_DB", MODE_PRIVATE)
    }

    factory {
        SampleRepository(get())
    }


    factory {
        AuthRepository(get(), get())
    }

    viewModel {
        SampleViewModel(get())
    }

    viewModel {
        ProfileViewModel(get() as AuthRepository)
    }
    viewModel {
        HomeViewModel()
    }

    viewModel {
        AuthViewModel(get())
    }
}
