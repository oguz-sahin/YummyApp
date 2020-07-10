package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class AllRestaurantModel(
    @SerializedName("data")
    var data: List<AllRestaurantData>,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)