package com.example.yummyapp.MainPage.Restaurant.Mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MakeCommentViewModel(application: Application) : AndroidViewModel(application) {

    val repository = MakeCommentRepository(application)
    val status: LiveData<Boolean>

    init {
        this.status = repository.status
    }


    fun MakeComment(
        token: String,
        restaurantId: String,
        title: String,
        food_quality: Int,
        service: Int,
        location: Int,
        price: Int,
        comment: String
    ) {

        repository.MakeComment(
            token,
            restaurantId,
            title,
            food_quality,
            service,
            location,
            price,
            comment
        )
    }

}