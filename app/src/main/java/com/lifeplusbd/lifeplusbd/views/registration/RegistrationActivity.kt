package com.lifeplusbd.lifeplusbd.views.registration

import android.app.Activity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.lifeplusbd.lifeplusbd.R
import com.lifeplusbd.lifeplusbd.databinding.ActivityRegistrationBinding
import kotlinx.android.synthetic.main.activity_registration.*

private lateinit var binding : ActivityRegistrationBinding
var name: String = ""
var email: String = ""
var mobile: String = ""
var password: String = ""



class RegistrationActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kotlin extension functions added to String class.
        fun String.isValidEmail(): Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
        fun String.isValidPhone(): Boolean = this.isNotEmpty() && Patterns.PHONE.matcher(this).matches()

        binding.imgvBackToLogin.setOnClickListener({
            finish()
        })

        binding.cirRegisterButton.setOnClickListener({
            name = binding.editTextName.text.toString().trim()
            email = binding.editTextEmail.text.toString().trim()
            mobile = binding.editTextMobile.text.toString().trim()
            password = binding.editTextPassword.text.toString().trim()

            if(name.isNotEmpty() && email.isNotEmpty() && mobile.isNotEmpty() && password.isNotEmpty()){
                if(email.isValidEmail()){
                    if(mobile.isValidPhone()){
                        // saving registraion info into db

                    }else{
                        Toast.makeText(applicationContext, "Mobile Number is not correct. ", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(applicationContext, "Email is not correct. ", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(applicationContext, "Please fill all the information first. ", Toast.LENGTH_LONG).show()
            }

        })

    }

    fun onLoginClick(view: android.view.View) {
        finish()
    }
}