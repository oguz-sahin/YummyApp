package com.example.yummyapp.Sepetim.model


import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("details")
    var details: List<Detail>,
    @SerializedName("food_id")
    var foodİd: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("info")
    var info: İnfo,
    @SerializedName("price")
    var price: String,
    @SerializedName("quantity")
    var quantity: String
)