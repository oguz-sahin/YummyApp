package com.example.yummyapp.MainPage.Restaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.Data
import com.example.yummyapp.MainPage.Search.SearchActivity
import com.example.yummyapp.MainPage.Search.TabAdapter
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_restaurant.*

class restaurantActivity : AppCompatActivity() {
    private lateinit var adapter: TabAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val RestaurantData = intent.getSerializableExtra(Constans.ClickRestaurant) as Data
        Log.e("rsd", RestaurantData.toString())
        val vm = ViewModelProviders.of(this).get(restaurantViewModel::class.java)
        restaurant_name_tv.text = RestaurantData.name
        vm.putData(RestaurantData)
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

            startActivity(Intent(this, SearchActivity::class.java))
        }


    }
}
