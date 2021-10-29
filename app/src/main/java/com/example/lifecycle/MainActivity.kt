package com.example.lifecycle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val loginViewModel by lazy { ViewModelProvider(this)[LoginViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val txtUsername = binding.txtUsername
        val txtPassword = binding.txtPassword
        val btnLogin = binding.btnLogin
        val txtStatus = binding.txtStatus

        btnLogin.setOnClickListener {
            loginViewModel.login(txtUsername.text.toString(), txtPassword.text.toString())
        }

        //observing the liveData
        loginViewModel.loginStatus.observe(this, Observer {
            if (it) {
                txtStatus.setTextColor(Color.rgb(0, 128, 0))
                txtStatus.text = "Logged in"
            } else {
                txtStatus.setTextColor(Color.RED)
                txtStatus.text = "Not logged in"
            }
        })
    }
}