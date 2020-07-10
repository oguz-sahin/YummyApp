package com.example.yummyapp.Sepetim.model


import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("name")
    var name: String,
    @SerializedName("secenek")
    var secenek: String
)