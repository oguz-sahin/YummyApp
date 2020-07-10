package com.example.yummyapp.Sepetim


import com.google.gson.annotations.SerializedName

data class BasketProductDetailModel(
    @SerializedName("data")
    var `data`: MutableList<Data>,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)