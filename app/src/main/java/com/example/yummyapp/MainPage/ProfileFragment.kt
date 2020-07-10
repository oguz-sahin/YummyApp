package com.example.yummyapp.MainPage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yummyapp.Constans
import com.example.yummyapp.Gone
import com.example.yummyapp.Login.Login
import com.example.yummyapp.Profile.FavoriteRestaurantActivity
import com.example.yummyapp.Profile.Friends.Friends_activity
import com.example.yummyapp.Profile.InviteandWinActivity
import com.example.yummyapp.Profile.YummyAboutActivity
import com.example.yummyapp.Profile.historicalActivity
import com.example.yummyapp.R
import com.example.yummyapp.Register.RegisterActivity
import com.example.yummyapp.Visible
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val prefences =
            activity?.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = prefences?.getString(Constans.KEY_NAME, "")



        if (token == "guest") {

            profile_full.Gone()
            goRegisterButton.Visible()
            guestEror.Visible()

            goRegisterButton.setOnClickListener {

                startActivity(Intent(this.activity, RegisterActivity::class.java))

            }

        } else {

            profile_full.Visible()
            guestEror.Gone()
            goRegisterButton.Gone()


            cardView12.setOnClickListener {
                val editor = prefences?.edit()
                editor?.putString(Constans.KEY_NAME, "guest")
                editor?.apply()
                startActivity(Intent(this.activity, Login::class.java))
                activity?.finish()
            }

            cardView10.setOnClickListener {

                startActivity(
                    Intent(
                        this.activity,
                        InviteandWinActivity::class.java
                    )
                )


            }

            cardView4.setOnClickListener {

                startActivity(
                    Intent(
                        this.activity,
                        FavoriteRestaurantActivity::class.java
                    )
                )


            }

            cardView9.setOnClickListener {
                startActivity(
                    Intent(
                        this.activity,
                        Friends_activity::class.java
                    )
                )

            }

            cardView11.setOnClickListener {

                startActivity(
                    Intent(
                        this.activity,
                        YummyAboutActivity::class.java
                    )
                )

            }

            cardView5.setOnClickListener {

                startActivity(
                    Intent(
                        this.activity,
                        historicalActivity::class.java
                    )
                )
            }


        }


    }

}
