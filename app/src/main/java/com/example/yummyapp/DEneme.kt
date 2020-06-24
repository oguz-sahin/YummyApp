package com.example.yummyapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.yummyapp.MainPage.Model.viewModel

class DEneme : AppCompatActivity() {


    private lateinit var vm: viewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_eneme)



        vm = ViewModelProviders.of(this).get(viewModel::class.java)
        vm.getRestaurantsWithToken("Bearer 5130d590daffc6374bff66bbc3b1642e28a9a2cd")
        vm.restaurants.observe(this, Observer {
            Log.e("tag", it.data.toString())

        })










    }
}
