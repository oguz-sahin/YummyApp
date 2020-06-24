package com.example.yummyapp.MainPage.Service

import com.example.yummyapp.MainPage.Model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {

    @GET("restaurants")
    fun getRestaurants(@Header("Authorization") token: String): Call<RestaurantModel>

    @GET("restaurant/{id}/images")
    fun getRestaurantsPhotos(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<photosModel>

    @GET("restaurant/{id}/comments")
    fun getRestaurantsComments(
        @Path("id") id: String,
        @Header("Authorization") token: String
    ): Call<CommentModel>

    @GET("restaurant/{id}/menus")

    fun getRestaurantsMenuCategories(
        @Path("id") id: String,
        @Header("Authorization") token: String
    ): Call<CategoryModel>

    @GET("restaurant/{id}")
    fun getRestaurantsInformation(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<restaurantResponse>



}