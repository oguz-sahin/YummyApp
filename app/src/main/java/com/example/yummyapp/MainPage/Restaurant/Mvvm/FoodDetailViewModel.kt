package com.example.yummyapp.MainPage.Restaurant.Mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.yummyapp.MainPage.Restaurant.order.FoodDetailModel.FoodDetailModel

class FoodDetailViewModel(application: Application) : AndroidViewModel(application) {

    val repository = FoodDetailRepository(application)
    val foodDetails: LiveData<FoodDetailModel>


    init {

        this.foodDetails = repository.foodDetails
    }

    fun getFoodDetails(token: String, foodId: String) {
        repository.getFoodDetail(token, foodId)
    }


}