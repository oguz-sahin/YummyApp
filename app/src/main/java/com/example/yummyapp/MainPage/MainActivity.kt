package com.example.yummyapp.MainPage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fragmentTransact(HomeFragment())


        bottom_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    fragmentTransact(HomeFragment())

                    true
                }
                R.id.action_sepetim -> {
                    fragmentTransact(AdisyonFragment())

                    true
                }
                R.id.action_profile -> {
                    fragmentTransact(ProfileFragment())

                    true
                }
                R.id.action_talep -> {
                    fragmentTransact(TaleplerFragment())

                    true
                }
                else -> TODO()
            }
        }


    }

    private fun fragmentTransact(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
