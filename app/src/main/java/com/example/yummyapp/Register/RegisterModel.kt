package com.example.yummyapp.Register


import com.google.gson.annotations.SerializedName

data class RegisterModel(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)