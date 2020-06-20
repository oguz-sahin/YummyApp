package com.example.yummyapp.MainPage.UserApi


import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: Any,
    @SerializedName("status")
    var status: Boolean
)