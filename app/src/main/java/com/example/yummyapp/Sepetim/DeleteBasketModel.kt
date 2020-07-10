package com.example.yummyapp.Sepetim


import com.google.gson.annotations.SerializedName

data class DeleteBasketModel(

    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)