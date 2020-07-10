package com.example.yummyapp.Profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.yummyapp.Constans
import com.example.yummyapp.Gone
import com.example.yummyapp.MainPage.Restaurant.restaurantActivity
import com.example.yummyapp.R
import com.example.yummyapp.Sepetim.BasketViewModel
import com.example.yummyapp.Visible
import kotlinx.android.synthetic.main.activity_favorite_restaurant.*

class FavoriteRestaurantActivity : AppCompatActivity(), OnClickFavoriteRestaurant {


    lateinit var vm: BasketViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_restaurant)


        vm = ViewModelProvider(this@FavoriteRestaurantActivity).get(BasketViewModel::class.java)

        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")


        vm.getFavoritesrestaurants(token!!)
        vm.favoriteRestaurants.observe(this, Observer {


            if (it.status) {
                recyclerview.Visible()
                eror_text.Gone()
                recyclerview.layoutManager = GridLayoutManager(this@FavoriteRestaurantActivity, 2)
                Log.e("like", it.data.toString())
                recyclerview.adapter =
                    FavoriteRestaurantAdapter(
                        it.data,
                        this@FavoriteRestaurantActivity,
                        this@FavoriteRestaurantActivity
                    )
            } else {

                recyclerview.Gone()
                eror_text.Visible()

            }


        })




        back.setOnClickListener {

            onBackPressed()
        }


    }

    override fun onClick(item: com.example.yummyapp.Profile.Model.Data) {

        val prefences = getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val editor = prefences?.edit()
        editor?.putString(Constans.RestaurantID, item.id)
        editor?.commit()


        startActivity(Intent(this, restaurantActivity::class.java))
    }


}
