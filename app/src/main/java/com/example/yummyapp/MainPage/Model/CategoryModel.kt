package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("data")
    var `data`: List<Categories>,
    @SerializedName("message")
    var message: Any,
    @SerializedName("status")
    var status: Boolean
)