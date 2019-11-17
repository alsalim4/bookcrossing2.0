package com.example.bookcrossing.presentation.auth

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.bookcrossing.MenuActivity
import com.example.bookcrossing.R
import com.example.bookcrossing.extensions.alert
import com.example.bookcrossing.extensions.toast
import com.example.bookcrossing.presentation.genre.GenreListActivity
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_auth.radioGroup
import kotlinx.android.synthetic.main.activity_auth.signIn_radio_button
import kotlinx.android.synthetic.main.activity_auth.singUp_radio_button
import org.koin.androidx.viewmodel.ext.android.getViewModel

class AuthActivity : AppCompatActivity() {
    lateinit var viewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
        if (viewModel.repository.isUserLogged()) {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        setContentView(R.layout.activity_auth)

        lostPassword.setOnClickListener{

        }

        singUpButton.setOnClickListener{
            viewModel.register(
                editReg.text.toString().trim(),
                editEmail.text.toString().trim(),
                editText3.text.toString().trim()
            )
        }
        singButton.setOnClickListener{
            viewModel.login(
                editLogin.text.toString().trim(),
                editText2.text.toString().trim()
            )
            val loginIntent = Intent(this, GenreListActivity::class.java)
            startActivity(loginIntent)
        }
        viewModel.loginLiveData.observe(this, Observer {
            toast(it)
        })
        viewModel.registrationLiveData.observe(this, Observer {
            this.toast(it)
            setContentView(R.layout.activiry_regdonepage)
        })

        /**
         * для отоброжения ошибок
         */
        viewModel.messageLiveData.observe(this, Observer {
            this.alert(message = it)
        })


        /**
         * для отоброжения ошибок
         */
        viewModel.messageLiveData.observe(this, Observer {
            alert(message = it)
        })

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.signIn_radio_button -> {
                    signIn_radio_button.setTextColor(Color.WHITE)
                    singUp_radio_button.setTextColor(ContextCompat.getColor(this, R.color.gray))
                    signUpPage.visibility = View.GONE
                    loginLayout.visibility = View.VISIBLE
                    signInTextView.text="Sign in"
                }
                R.id.singUp_radio_button -> {
                    signIn_radio_button.setTextColor(ContextCompat.getColor(this, R.color.gray))
                    singUp_radio_button.setTextColor(Color.WHITE)
                    signUpPage.visibility = View.VISIBLE
                    loginLayout.visibility = View.GONE
                    signInTextView.text="Sign up"
                }
            }

        }
    }
}
