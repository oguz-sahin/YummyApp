package com.example.yummyapp.Register


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("token")
    var token: String,
    @SerializedName("user_id")
    var userİd: String
)