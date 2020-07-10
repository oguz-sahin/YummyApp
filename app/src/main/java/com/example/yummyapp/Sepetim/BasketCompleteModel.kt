package com.example.yummyapp.Sepetim


import com.google.gson.annotations.SerializedName

data class BasketCompleteModel(
    @SerializedName("data")
    var `data`: Int,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)