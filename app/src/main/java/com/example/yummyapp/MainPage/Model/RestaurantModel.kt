package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RestaurantModel(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
) : Serializable