package com.example.yummyapp.Login


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("token")
    var token: String
)