package com.example.yummyapp.Register

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {


    @POST("register")
    @FormUrlEncoded
    fun Register(
        @Field("mail") mail: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("phone") phone: String
    ): Call<RegisterModel>


}