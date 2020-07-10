package com.example.yummyapp.MainPage.Restaurant.Mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Model.*
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class restaurantRepository(application: Application) {

    val restaurantsPhotos = MutableLiveData<photosModel>()
    val restaurantInformation = MutableLiveData<restaurantResponse>()
    val restaurantComments = MutableLiveData<CommentModel>()
    val restaurantMenuCategories = MutableLiveData<CategoryModel>()
    val addFavoriteStatus = MutableLiveData<FavoriteStatusModel>()
    val deleteFavoriteStatus = MutableLiveData<FavoriteStatusModel>()

    fun getRestaurantPhotosWithToken(token: String, restarunatID: String) {
        val BASE_URL = "http://apiyummy.wookweb.com/"
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ApiService::class.java)

        service.getRestaurantsPhotos("Baerer " + token, restarunatID)
            .enqueue(object : Callback<photosModel> {
                override fun onFailure(call: Call<photosModel>, t: Throwable) {
                    Log.e("tag", t.message)
                }

                override fun onResponse(call: Call<photosModel>, response: Response<photosModel>) {
                    restaurantsPhotos.postValue(response.body())
                }


            })

    }

    fun getRestaurantInformation(token: String, restarunatID: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.getRestaurantsInformation("Bearer " + token, restarunatID)
            .enqueue(object : Callback<restaurantResponse> {
                override fun onFailure(call: Call<restaurantResponse>, t: Throwable) {
                    Log.e("getREstaurants Onfa", t.message)
                }

                override fun onResponse(
                    call: Call<restaurantResponse>,
                    response: Response<restaurantResponse>
                ) {

                    restaurantInformation.value = response.body()
                    Log.e("info restorant", response.body().toString())
                }


            })


    }

    fun getRestaurantComments(restaurantId: String, token: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.getRestaurantsComments(restaurantId, "Bearer " + token)
            .enqueue(object : Callback<CommentModel> {
                override fun onFailure(call: Call<CommentModel>, t: Throwable) {
                    Log.e("rEstaurants Comment api", t.message)
                }

                override fun onResponse(
                    call: Call<CommentModel>,
                    response: Response<CommentModel>
                ) {

                    restaurantComments.value = response.body()

                }


            })


    }


    fun getRestaurantMenuCategories(restarunatID: String, token: String) {
        val apiClient: ApiService by lazy { ApiClient.getApiClient() }
        apiClient.getRestaurantsMenuCategories(restarunatID, token)
            .enqueue(object : Callback<CategoryModel> {
                override fun onFailure(call: Call<CategoryModel>, t: Throwable) {
                    Log.e("onfailure menu categori", t.message)
                }

                override fun onResponse(
                    call: Call<CategoryModel>,
                    response: Response<CategoryModel>
                ) {
                    restaurantMenuCategories.value = response.body()
                }


            })


    }

    fun addFavorite(token: String, restarunatID: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.addFavorite("Bearer " + token, restarunatID)
            .enqueue(object : Callback<FavoriteStatusModel> {
                override fun onFailure(call: Call<FavoriteStatusModel>, t: Throwable) {
                    Log.e("on failere", t.message)
                }

                override fun onResponse(
                    call: Call<FavoriteStatusModel>,
                    response: Response<FavoriteStatusModel>
                ) {
                    Log.e("favorite add", response.body().toString())

                }


            })


    }


    fun deleteFavorite(token: String, restarunatID: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.deleteFavorite("Bearer " + token, restarunatID)
            .enqueue(object : Callback<FavoriteStatusModel> {
                override fun onFailure(call: Call<FavoriteStatusModel>, t: Throwable) {
                    Log.e("on failere dekete", t.message)
                }

                override fun onResponse(
                    call: Call<FavoriteStatusModel>,
                    response: Response<FavoriteStatusModel>
                ) {
                    Log.e("favorite delete", response.body().toString())

                }


            })


    }


}