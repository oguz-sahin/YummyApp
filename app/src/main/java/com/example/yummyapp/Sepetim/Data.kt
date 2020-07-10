package com.example.yummyapp.Sepetim


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("details")
    var details: MutableList<DetailX>,
    @SerializedName("food_id")
    var foodİd: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("order_id")
    var orderİd: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("quantity")
    var quantity: String,
    @SerializedName("restaurant_id")
    var restaurantİd: String,
    @SerializedName("session_id")
    var sessionİd: String,
    @SerializedName("user_id")
    var userİd: String
)