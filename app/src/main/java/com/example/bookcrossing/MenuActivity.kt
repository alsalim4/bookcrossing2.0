package com.example.bookcrossing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.bookcrossing.presentation.auth.AuthRepository
import com.example.bookcrossing.presentation.book.FavoriteFragment
import com.example.bookcrossing.presentation.book.HomeFragment
import com.example.bookcrossing.presentation.notification.YourBooks_fragment
import com.example.bookcrossing.presentation.profile.ProfileFragment
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
            R.id.navigation_community -> selectedFragment = YourBooks_fragment()
            R.id.navigation_profile -> selectedFragment = ProfileFragment()
            R.id.navigation_favorite -> selectedFragment = FavoriteFragment()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, selectedFragment)
            .commit()
        true
    }

}

