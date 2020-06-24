package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class CommentModel(
    @SerializedName("data")
    var `data`: List<Comment>,
    @SerializedName("message")
    var message: Any,
    @SerializedName("status")
    var status: Boolean
)