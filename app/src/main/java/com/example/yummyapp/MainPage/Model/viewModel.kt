package com.example.yummyapp.MainPage.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class viewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    val showProgress: LiveData<Boolean>
    val restaurants: LiveData<RestaurantModel>
    val allRestaurants: LiveData<AllRestaurantModel>
    val popularRestaurants: LiveData<AllRestaurantModel>
    val topRestaurants: LiveData<AllRestaurantModel>

    // val code:LiveData<Int>
    val Code = MutableLiveData<Int>()
    fun CodeControl(code: Int) {

        Code.value = code

    }

    init {
        this.showProgress = repository.showProgress
        this.restaurants = repository.restaurants
        this.allRestaurants = repository.allRestaurants
        this.popularRestaurants = repository.popularRestaurants
        this.topRestaurants = repository.topRestaurants
        //this.code=repository.clickCode
    }

    fun changeState() {
        repository.changeState()
    }

    fun getRestaurantsWithToken(token: String) {
        repository.getRestaurantWithToken(token)
    }

    fun getAllRestaurants(
        token: String,
        city: String,
        query: String,
        order: String,
        filter: ArrayList<String>
    ) {

        repository.getAllRestaurants(token, city, query, order, filter)
    }

    fun getPopularestaurants(
        token: String,
        city: String,
        query: String,
        order: String,
        filter: ArrayList<String>
    ) {

        repository.getPopularRestaurants(token, city, query, order, filter)
    }

    fun getToprestaurants(
        token: String,
        city: String,
        query: String,
        order: String,
        filter: ArrayList<String>
    ) {

        repository.getTopRestaurants(token, city, query, order, filter)
    }


    /*/ fun CodeControl(Code:Int){
         repository.CodeControl(Code)
     }*/

}