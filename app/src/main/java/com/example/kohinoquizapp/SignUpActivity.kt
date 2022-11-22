package com.example.kohinoquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kohinoquizapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    lateinit var signupBinding: ActivitySignUpBinding
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signupBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signupBinding.root
        setContentView(view)

        signupBinding.buttonSignUp.setOnClickListener {
            val email = signupBinding.editTextSignUpEmail.text.toString()
            val password = signupBinding.editTextSignUpPass.text.toString()

            signUpWithFirebase(email, password)
        }
    }

    private fun signUpWithFirebase(email: String, password: String) {

        signupBinding.progressBarSignUp.visibility = View.VISIBLE

        signupBinding.buttonSignUp.isClickable = false

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->

            if (task.isSuccessful) {

                Toast.makeText(
                    applicationContext,
                    "Your account has been created",
                    Toast.LENGTH_SHORT
                ).show()
                finish()

                signupBinding.progressBarSignUp.visibility = View.INVISIBLE
                signupBinding.buttonSignUp.isClickable = true

            } else {

                Toast.makeText(
                    applicationContext,
                    task.exception?.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
}