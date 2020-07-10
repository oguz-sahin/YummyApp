package com.example.yummyapp.MainPage.Service

import com.example.yummyapp.MainPage.Model.*
import com.example.yummyapp.MainPage.Restaurant.order.FoodDetailModel.FoodDetailModel
import com.example.yummyapp.MainPage.Restaurant.order.FoodListModel.FoodListModel
import com.example.yummyapp.Profile.Friends.Model.FriendListModel
import com.example.yummyapp.Profile.Model.FavoriteRestaurantModel
import com.example.yummyapp.Profile.Model.HistoricOrderModel
import com.example.yummyapp.Sepetim.BasketCompleteModel
import com.example.yummyapp.Sepetim.BasketProductDetailModel
import com.example.yummyapp.Sepetim.DeleteBasketModel
import com.example.yummyapp.Sepetim.model.BasketCompleteDetailModel
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("friends")
    fun getFriendList(@Header("Authorization") token: String): Call<FriendListModel>


    @GET("restaurants")
    fun getRestaurants(@Header("Authorization") token: String): Call<RestaurantModel>

    @GET("restaurant/{id}/images")
    fun getRestaurantsPhotos(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<photosModel>

    @GET("restaurant/{id}/comments")
    fun getRestaurantsComments(
        @Path("id") id: String,
        @Header("Authorization") token: String
    ): Call<CommentModel>

    @GET("restaurant/{id}/menus")

    fun getRestaurantsMenuCategories(
        @Path("id") id: String,
        @Header("Authorization") token: String
    ): Call<CategoryModel>

    @GET("restaurant/{id}")
    fun getRestaurantsInformation(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<restaurantResponse>


    @GET("restaurant/{restaurantId}/menu/{categoryId}")
    fun getFoodList(
        @Header("Authorization") token: String,
        @Path("restaurantId") restaurantId: String,
        @Path("categoryId") CategoryId: String
    ): Call<FoodListModel>

    @POST("restaurant/{id}/comment")
    @FormUrlEncoded
    fun PostComment(
        @Header("Authorization") token: String,
        @Path("id") restaurantId: String,
        @Field("title") title: String,
        @Field("food_quality") food_quality: Int,
        @Field("service") service: Int,
        @Field("location") location: Int,
        @Field("price") price: Int,
        @Field("comment") comment: String
    ): Call<CommentModelX>


    @GET("food/{id}")
    fun getFoodDeatils(
        @Header("Authorization") token: String,
        @Path("id") foodId: String
    ): Call<FoodDetailModel>

    @GET("basket")
    fun getBasket(@Header("Authorization") token: String): Call<BasketModel>

    @GET("basket/{id}")
    fun getBasketDetail(
        @Header("Authorization") token: String,
        @Path("id") restaurantId: String
    ): Call<BasketProductDetailModel>

    @DELETE("basket/{id}")
    fun deleteBasket(
        @Header("Authorization") token: String,
        @Path("id") restaurantId: String
    ): Call<DeleteBasketModel>


    @POST("basket/{id}/complete")
    @FormUrlEncoded
    fun completeBasket(
        @Header("Authorization") token: String,
        @Path("id") restaurantId: String,
        @Field("day") day: String,
        @Field("time") time: String
    ): Call<BasketCompleteModel>


    @GET("order/{id}")
    fun getCompleteBasketDetail(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<BasketCompleteDetailModel>

    @GET("orders")
    fun getHistoricOrders(@Header("Authorization") token: String): Call<HistoricOrderModel>

    @GET("favorites")
    fun getFavoriteRestaurants(@Header("Authorization") token: String): Call<FavoriteRestaurantModel>


    @POST("restaurant/{id}/favorite")
    fun addFavorite(
        @Header("Authorization") token: String,
        @Path("id") restaurantId: String
    ): Call<FavoriteStatusModel>

    @DELETE("restaurant/{id}/favorite")
    fun deleteFavorite(
        @Header("Authorization") token: String,
        @Path("id") restaurantId: String
    ): Call<FavoriteStatusModel>

    @POST("search")
    @FormUrlEncoded
    fun getAllRestaurants(
        @Header("Authorization") token: String,
        @Field("city") city: String,
        @Field("query") query: String,
        @Field("order") order: String,
        @Field("filter") filter: ArrayList<String>
    ): Call<AllRestaurantModel>

    @POST("search/location")
    @FormUrlEncoded
    fun getNearRestaurants(
        @Header("Authorization") token: String,
        @Field("latitude") latitude: String,
        @Field("longitude") longitude: String,
        @Field("city") city: String,
        @Field("query") query: String,
        @Field("order") order: String,
        @Field("filter") filter: String
    )//caLL VE MODEL SINIFI

    @POST("search/popular")
    @FormUrlEncoded
    fun getPopularRestaurants(
        @Header("Authorization") token: String,
        @Field("city") city: String,
        @Field("query") query: String,
        @Field("order") order: String,
        @Field("filter") filter: ArrayList<String>
    ): Call<AllRestaurantModel>

    @POST("search/top")
    @FormUrlEncoded
    fun getTopRestaurants(
        @Header("Authorization") token: String,
        @Field("city") city: String,
        @Field("query") query: String,
        @Field("order") order: String,
        @Field("filter") filter: ArrayList<String>
    ): Call<AllRestaurantModel>



}