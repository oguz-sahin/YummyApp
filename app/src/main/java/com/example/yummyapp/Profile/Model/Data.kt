package com.example.yummyapp.Profile.Model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("about")
    var about: String,
    @SerializedName("address")
    var address: String,
    @SerializedName("admin_not")
    var adminNot: String,
    @SerializedName("date")
    var date: String,
    @SerializedName("details")
    var details: Any,
    @SerializedName("id")
    var id: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("kitchen_type")
    var kitchenType: String,
    @SerializedName("latitude")
    var latitude: String,
    @SerializedName("longitude")
    var longitude: String,
    @SerializedName("mail")
    var mail: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("new_settings")
    var newSettings: String,
    @SerializedName("new_image")
    var newİmage: String,
    @SerializedName("open_days")
    var openDays: String,
    @SerializedName("open_hours")
    var openHours: Any,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("teslimat")
    var teslimat: String,
    @SerializedName("url")
    var url: String
)