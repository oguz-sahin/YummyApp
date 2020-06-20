package com.example.yummyapp.MainPage.Service

import com.example.yummyapp.MainPage.Model.RestaurantModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("restaurants")
    fun getRestaurants(@Header("Authorization") value: String): Call<RestaurantModel>


}