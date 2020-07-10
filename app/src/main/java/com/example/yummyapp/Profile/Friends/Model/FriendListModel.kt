package com.example.yummyapp.Profile.Friends.Model


import com.google.gson.annotations.SerializedName

data class FriendListModel(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)