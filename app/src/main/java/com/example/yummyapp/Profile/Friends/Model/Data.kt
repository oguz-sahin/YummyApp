package com.example.yummyapp.Profile.Friends.Model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("user")
    var user: User
)