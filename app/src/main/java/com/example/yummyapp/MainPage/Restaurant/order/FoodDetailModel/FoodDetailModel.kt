package com.example.yummyapp.MainPage.Restaurant.order.FoodDetailModel


import com.google.gson.annotations.SerializedName

data class FoodDetailModel(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: Any,
    @SerializedName("status")
    var status: Boolean
)