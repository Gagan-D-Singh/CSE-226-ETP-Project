package com.example.kohinoquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.kohinoquizapp.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    lateinit var splashBinding : ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        // to give animation to textViews in splash screen
        val alphaAnimation = AnimationUtils.loadAnimation(applicationContext, R.anim.splash_anim)
        splashBinding.textViewSplash1.startAnimation(alphaAnimation)
        splashBinding.textViewSplash2.startAnimation(alphaAnimation)

        // for handling the splash screen and then switching to mainActivity
        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed(object: Runnable{
            override fun run() {
                val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 5000)
    }
}