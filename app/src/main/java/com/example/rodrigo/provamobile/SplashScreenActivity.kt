package com.example.rodrigo.provamobile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.rodrigo.provamobile.scenarios_main.MainActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlideApp.with(this)
            .load("https://i.pinimg.com/originals/1f/d9/30/1fd930302eb38570fe25282cf95b77b3.jpg")
            .placeholder(R.drawable.splashscreen)
            .into(imgLogoApp)

        Handler().postDelayed({
            val listaMeals = Intent(this, MainActivity::class.java)
            startActivity(listaMeals)
            finish()
        }, 2000)


    }
}
