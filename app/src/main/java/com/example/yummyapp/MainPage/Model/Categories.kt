package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("restaurant_id")
    var restaurantİd: String,
    @SerializedName("sort")
    var sort: String,
    @SerializedName("image")
    var image: String
)