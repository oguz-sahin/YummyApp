package com.example.yummyapp.Profile.Model


import com.google.gson.annotations.SerializedName

data class FavoriteRestaurantModel(
    @SerializedName("data")
    var `data`: ArrayList<Data>,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)