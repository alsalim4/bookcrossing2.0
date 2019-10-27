package com.example.bookcrossing.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bookcrossing.presentation.auth.AuthActivity
import com.example.bookcrossing.presentation.sample.SampleActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }
}
