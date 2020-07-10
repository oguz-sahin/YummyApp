package com.example.yummyapp.Sepetim.model


import com.google.gson.annotations.SerializedName

data class BasketCompleteDetailModel(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)