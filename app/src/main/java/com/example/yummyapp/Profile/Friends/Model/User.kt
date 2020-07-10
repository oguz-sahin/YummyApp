package com.example.yummyapp.Profile.Friends.Model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id: String,
    @SerializedName("mail")
    var mail: String,
    @SerializedName("name")
    var name: String
)