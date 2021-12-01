package com.lifeplusbd.lifeplusbd.views.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.lifeplusbd.lifeplusbd.R
import com.lifeplusbd.lifeplusbd.views.registration.RegistrationActivity

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContentView(R.layout.activity_login)
    }

    fun onLoginClick(view: android.view.View) {
        startActivity(Intent(applicationContext, RegistrationActivity::class.java))
    }
}