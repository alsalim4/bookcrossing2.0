package com.example.bookcrossing.presentation.book

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bookcrossing.MenuActivity
import com.example.bookcrossing.R
import com.example.bookcrossing.presentation.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_book.*

class BookActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        OwnerTitle.setOnClickListener {
            val loginIntent = Intent(this, ProfileActivity::class.java)
            startActivity(loginIntent)
        }
        expand.setOnClickListener{
            descText.maxLines=20
            expand.visibility= View.GONE
        }
        backBtn.setOnClickListener{
            val loginIntent = Intent(this, MenuActivity::class.java)
            startActivity(loginIntent)
        }

    }

}