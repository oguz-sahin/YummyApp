package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class photosModel(
    @SerializedName("data")
    var `data`: List<Photo>,
    @SerializedName("message")
    var message: Any,
    @SerializedName("status")
    var status: Boolean
)