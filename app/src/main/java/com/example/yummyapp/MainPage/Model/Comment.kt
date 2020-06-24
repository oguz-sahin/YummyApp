package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("date")
    var date: String,
    @SerializedName("food")
    var food: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("images")
    var images: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("restaurant_id")
    var restaurantİd: String,
    @SerializedName("service")
    var service: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("text")
    var text: String,
    @SerializedName("title")
    var title: String
)