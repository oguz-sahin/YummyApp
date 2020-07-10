package com.example.yummyapp.Profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.yummyapp.Profile.Model.FavoriteRestaurantModel

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    val repository = ProfileRepository(application)

    val favoriteRestaurants: LiveData<FavoriteRestaurantModel>


    init {
        this.favoriteRestaurants = repository.favoriteRestaurant
    }


    fun getFavoritesrestaurants(token: String) {

        repository.getFavoriteRestaurant(token)

    }
}