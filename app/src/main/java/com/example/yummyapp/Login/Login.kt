package com.example.yummyapp.Login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yummyapp.MainPage.MainActivity
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        girisYap_button.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))

        }
    }
}
