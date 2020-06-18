package com.example.yummyapp.Login

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {


    @POST("login")
    @FormUrlEncoded
    fun loginWithEmailandPassword(
        @Field("mail") mail: String,
        @Field("password") password: String
    ): Call<LoginModel>


}