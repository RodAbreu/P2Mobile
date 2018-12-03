package com.example.rodrigo.provamobile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.rodrigo.provamobile.scenarios_main.MainActivity
import com.example.rodrigo.provamobile.utils.GlideApp
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlideApp.with(this)
            .load("")
            .placeholder(R.drawable.splashscreen)
            .into(imgLogoApp)

        Handler().postDelayed({
            val listaMeals = Intent(this, MainActivity::class.java)
            startActivity(listaMeals)
            finish()
        }, 2000)


    }
}
