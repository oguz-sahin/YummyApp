package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class FavoriteStatusModel(

    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)