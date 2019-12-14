package com.example.bookcrossing.presentation.book

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bookcrossing.R
import kotlinx.android.synthetic.main.activity_book.*

class BookActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(R.layout.activity_book)
        super.onCreate(savedInstanceState, persistentState)
    }

}