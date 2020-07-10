package com.example.yummyapp.MainPage.Restaurant.order.FoodListModel


import com.google.gson.annotations.SerializedName

data class FoodListModel(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("message")
    var message: Any,
    @SerializedName("status")
    var status: Boolean
)