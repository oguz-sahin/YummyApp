package com.example.yummyapp.Profile.Model


import com.google.gson.annotations.SerializedName

data class HistoricOrderModel(
    @SerializedName("data")
    var `data`: List<DataHistoric>,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)