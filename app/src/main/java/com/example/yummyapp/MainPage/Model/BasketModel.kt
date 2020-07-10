package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class BasketModel(
    @SerializedName("data")
    var `data`: MutableList<Basket>,
    @SerializedName("message")
    var message: Any,
    @SerializedName("status")
    var status: Boolean

)