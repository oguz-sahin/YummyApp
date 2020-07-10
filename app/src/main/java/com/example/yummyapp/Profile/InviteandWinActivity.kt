package com.example.yummyapp.Profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_inviteand_win.*

class InviteandWinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inviteand_win)


        back.setOnClickListener {

            onBackPressed()
        }


    }
}
