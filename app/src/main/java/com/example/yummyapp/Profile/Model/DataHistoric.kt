package com.example.yummyapp.Profile.Model


import com.google.gson.annotations.SerializedName

data class DataHistoric(
    @SerializedName("date")
    var date: String,
    @SerializedName("day")
    var day: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("pin")
    var pin: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("price2")
    var price2: String,
    @SerializedName("restaurant_id")
    var restaurantİd: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("time")
    var time: String,
    @SerializedName("type")
    var type: Any,
    @SerializedName("user_id")
    var userİd: String
)