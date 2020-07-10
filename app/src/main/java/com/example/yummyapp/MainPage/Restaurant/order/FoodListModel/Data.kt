package com.example.yummyapp.MainPage.Restaurant.order.FoodListModel


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("calorie")
    var calorie: String,
    @SerializedName("description")
    var description: Any,
    @SerializedName("gluten")
    var gluten: String,
    @SerializedName("hot")
    var hot: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("menu_id")
    var menuİd: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("options")
    var options: List<Option>,
    @SerializedName("organic")
    var organic: String,
    @SerializedName("pig_meat")
    var pigMeat: String,
    @SerializedName("preparation_time")
    var preparationTime: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("restaurant_id")
    var restaurantİd: String,
    @SerializedName("vegan")
    var vegan: String
)