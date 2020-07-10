package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class Basket(
    @SerializedName("name")
    var name: String?,
    @SerializedName("price")
    var price: String?,
    @SerializedName("restaurant_id")
    var restaurantİd: String?
)