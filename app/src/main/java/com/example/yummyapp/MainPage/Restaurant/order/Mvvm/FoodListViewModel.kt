package com.example.yummyapp.MainPage.Restaurant.order.Mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.yummyapp.MainPage.Restaurant.order.FoodListModel.FoodListModel

class FoodListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = FoodListRepository(application)
    val foodList: LiveData<FoodListModel>


    init {
        this.foodList = repository.FoodList
    }


    fun getFoodList(token: String, restaurantId: String, categoryId: String) {


        repository.getFoodList(token, restaurantId, categoryId)

    }


}