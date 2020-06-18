package com.example.yummyapp.Login


import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)