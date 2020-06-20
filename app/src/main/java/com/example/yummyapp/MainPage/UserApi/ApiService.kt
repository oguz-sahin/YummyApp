package com.example.yummyapp.MainPage.UserApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header


interface ApiService {

    @GET("user")
    fun getUserInformation(@Header("Authorization") Auth: String): Call<UserModel>

}