package com.example.bookcrossing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.bookcrossing.presentation.book.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, HomeFragment())
            .commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment = HomeFragment()
        when (item.itemId) {
            R.id.navigation_home -> selectedFragment = HomeFragment()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, selectedFragment)
            .commit()
        true
    }

}

