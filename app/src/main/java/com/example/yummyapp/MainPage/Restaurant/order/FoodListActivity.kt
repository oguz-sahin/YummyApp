package com.example.yummyapp.MainPage.Restaurant.order

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Restaurant.order.Mvvm.FoodListViewModel
import com.example.yummyapp.MainPage.Restaurant.order.Utill.ItemClickFood
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_food_list.*

class FoodListActivity : AppCompatActivity(), ItemClickFood {

    private lateinit var vm: FoodListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_list)

        var categoryId = intent.getStringExtra(Constans.CategoryId)

        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")

        //RestaurantId
        val prefences = getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val restaurantId = prefences?.getString(Constans.RestaurantID, "0")

        vm = ViewModelProviders.of(this).get(FoodListViewModel::class.java)

        vm.getFoodList(token!!, restaurantId!!, categoryId)
        vm.foodList.observe(this, androidx.lifecycle.Observer {

            Log.e("data geldi", it.data[0].toString())
            recyclerview.adapter = FoodListAdapter(it.data, this)
            recyclerview.layoutManager = LinearLayoutManager(this)

        })


        back.setOnClickListener {

            onBackPressed()

        }


    }

    override fun ClikFoodItem(FoodInformation: com.example.yummyapp.MainPage.Restaurant.order.FoodListModel.Data) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra(Constans.food_id, FoodInformation.id)
        startActivity(intent)
    }
}
