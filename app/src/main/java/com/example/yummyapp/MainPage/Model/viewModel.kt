package com.example.yummyapp.MainPage.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viewModel : ViewModel() {
    var LiveREsponse = MutableLiveData<RestaurantModel>()
    fun putResponse(response: RestaurantModel) {
        LiveREsponse.value = response
    }
}