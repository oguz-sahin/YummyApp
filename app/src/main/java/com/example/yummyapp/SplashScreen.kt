package com.example.yummyapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.yummyapp.Login.Login

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

        startActivity(Intent(this@SplashScreen, Login::class.java))


    }


}
