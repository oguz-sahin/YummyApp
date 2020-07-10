package com.example.yummyapp.MainPage.Model


import com.google.gson.annotations.SerializedName


//Yorum yaptıktan sonra gelen cevap
data class CommentModelX(
    @SerializedName("data")
    var `data`: DataX,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)