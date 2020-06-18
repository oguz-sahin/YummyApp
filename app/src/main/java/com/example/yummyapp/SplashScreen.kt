package com.example.yummyapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.yummyapp.Constans.PREFS_FILENAME
import com.example.yummyapp.MainPage.MainActivity
import com.example.yummyapp.OnboardScreen.introScreen

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(
            {
                userControl()

            },
            2000
        )
    }


    fun userControl() {


        val prefences = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = prefences.getString(Constans.KEY_NAME, "")
        if (token == "") {
            startActivity(Intent(this@SplashScreen, introScreen::class.java))
        } else {

            startActivity(Intent(this@SplashScreen, MainActivity::class.java))

        }




    }


}
