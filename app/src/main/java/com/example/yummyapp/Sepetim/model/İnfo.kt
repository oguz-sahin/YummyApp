package com.example.yummyapp.Sepetim.model


import com.google.gson.annotations.SerializedName

data class İnfo(
    @SerializedName("image")
    var image: String,
    @SerializedName("name")
    var name: String
)