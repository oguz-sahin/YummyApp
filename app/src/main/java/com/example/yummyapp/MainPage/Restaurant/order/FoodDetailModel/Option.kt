package com.example.yummyapp.MainPage.Restaurant.order.FoodDetailModel


import com.google.gson.annotations.SerializedName

data class Option(
    @SerializedName("baslik")
    var baslik: String,
    @SerializedName("deger")
    var deger: List<String>,
    @SerializedName("fiyat")
    var fiyat: List<String>,
    @SerializedName("type")
    var type: String
)