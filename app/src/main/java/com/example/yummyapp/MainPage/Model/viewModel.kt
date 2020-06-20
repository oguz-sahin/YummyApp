package com.example.yummyapp.MainPage.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class viewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    val showProgress: LiveData<Boolean>
    val restaurants: LiveData<RestaurantModel>

    init {
        this.showProgress = repository.showProgress
        this.restaurants = repository.restaurants
    }

    fun changeState() {
        repository.changeState()
    }

    fun getRestaurantsWithToken(token: String) {
        repository.getRestaurantWithToken(token)
    }

}