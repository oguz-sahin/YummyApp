package com.example.yummyapp.MainPage.UserApi


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("admin")
    var admin: String,
    @SerializedName("bonus")
    var bonus: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("mail")
    var mail: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("registrationDate")
    var registrationDate: String
)