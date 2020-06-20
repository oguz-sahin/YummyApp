package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Rate(
    @SerializedName("avg")
    var avg: String,
    @SerializedName("comment_count")
    var commentCount: String,
    @SerializedName("food")
    var food: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("service")
    var service: String
) : Serializable