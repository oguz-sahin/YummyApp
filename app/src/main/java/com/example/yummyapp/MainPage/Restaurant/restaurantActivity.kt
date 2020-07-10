package com.example.yummyapp.MainPage.Restaurant

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.yummyapp.Constans
import com.example.yummyapp.Gone
import com.example.yummyapp.MainPage.Model.restaurantResponse
import com.example.yummyapp.MainPage.Restaurant.Mvvm.restaurantViewModel
import com.example.yummyapp.MainPage.Search.TabAdapter
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_restaurant.*

class restaurantActivity : AppCompatActivity() {
    private lateinit var adapter: TabAdapter
    var favoriteStatus: Boolean = false
    lateinit var response: restaurantResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)


        //RestaurantId

        val vm = ViewModelProviders.of(this).get(restaurantViewModel::class.java)

        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")


        //RestaurantId
        val prefences = getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val restaurantId = prefences?.getString(Constans.RestaurantID, "0")




        vm.getRestaurantInformation(token!!, restaurantId!!)
        vm.restaurantResponse.observe(this, Observer {
            restaurant_name_tv.text = it.data.name
            favoriteStatus = it.data.favorite
            Log.e("tag", favoriteStatus.toString())
            response = it

            if (token != "guest") {
                if (response.data.favorite) {
                    favorite_iv.setImageResource(R.mipmap.ant_design_heart_filled)
                } else if (response.data.favorite == false) {
                    favorite_iv.setImageResource(R.mipmap.ant_design_heart_outlined)
                }

                favorite_iv.setOnClickListener {

                    if (favoriteStatus) {
                        favorite_iv.setImageResource(R.mipmap.ant_design_heart_outlined)
                        favoriteStatus = false
                        vm.deleteFavorite(token, restaurantId)

                    } else if (favoriteStatus == false) {

                        favorite_iv.setImageResource(R.mipmap.ant_design_heart_filled)
                        favoriteStatus = true
                        vm.addFavorite(token, restaurantId)
                    }

                }

            } else {

                favorite_iv.Gone()

            }

        })





        adapter = TabAdapter(supportFragmentManager)

        adapter.apply {
            addFragment(AboutFragment(), "Hakkında")
            addFragment(MenuFragment(), "Menü")
            addFragment(CommentFragment(), "Yorumlar")
            addFragment(DirectionsFragment(), "Yol Tarifi")
        }
        view_pager.adapter = adapter
        tabLayout.setupWithViewPager(view_pager)

        back.setOnClickListener {

            onBackPressed()
        }


    }
}
