package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class restaurantResponse(
    @SerializedName("data")
    var `data`: DataXX,
    @SerializedName("message")
    var message: Any,
    @SerializedName("status")
    var status: Boolean
)