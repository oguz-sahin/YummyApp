package com.example.yummyapp.MainPage.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class viewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    val showProgress: LiveData<Boolean>
    val restaurants: LiveData<RestaurantModel>

    // val code:LiveData<Int>
    val Code = MutableLiveData<Int>()
    fun CodeControl(code: Int) {

        Code.value = code

    }

    init {
        this.showProgress = repository.showProgress
        this.restaurants = repository.restaurants
        //this.code=repository.clickCode
    }

    fun changeState() {
        repository.changeState()
    }

    fun getRestaurantsWithToken(token: String) {
        repository.getRestaurantWithToken(token)
    }
    /*/ fun CodeControl(Code:Int){
         repository.CodeControl(Code)
     }*/

}