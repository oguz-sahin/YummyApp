package com.example.yummyapp.Sepetim


import com.google.gson.annotations.SerializedName

data class DetailX(
    @SerializedName("name")
    var name: String,
    @SerializedName("secenek")
    var secenek: String
)