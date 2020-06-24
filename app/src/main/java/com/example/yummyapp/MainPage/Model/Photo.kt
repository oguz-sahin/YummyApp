package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    var id: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("restaurant_id")
    var restaurantİd: String,
    @SerializedName("type")
    var type: String
)