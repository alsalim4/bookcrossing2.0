package com.example.bookcrossing.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.bookcrossing.MenuActivity

import com.example.bookcrossing.entities.User
import com.example.bookcrossing.presentation.auth.AuthActivity
import com.example.bookcrossing.presentation.auth.AuthRepository
import kotlinx.android.synthetic.main.profile_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : Fragment(){
    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.bookcrossing.R.layout.profile_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logoutBtn.setOnClickListener{
            val loginIntent = Intent(context, AuthActivity::class.java)
            viewModel.repository.logoutUser()
            startActivity(loginIntent)
        }
        viewModel.onViewInitizialized()
        initObservers()
    }

    private fun initObservers() {
        viewModel.profilelivedata.observe(this, Observer {
            updateProfileUI(it)
        })
    }

    private fun updateProfileUI(user : User) {
        nameEditText.text = user.name
        emailEditText.text = user.username
    }

}