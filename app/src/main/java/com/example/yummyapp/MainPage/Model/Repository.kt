package com.example.yummyapp.MainPage.Model

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Repository(val application: Application) {

    val apiClient: ApiService by lazy { ApiClient.getApiClient() }

    val showProgress = MutableLiveData<Boolean>()
    val restaurants = MutableLiveData<RestaurantModel>()
    val allRestaurants = MutableLiveData<AllRestaurantModel>()
    val popularRestaurants = MutableLiveData<AllRestaurantModel>()
    val topRestaurants = MutableLiveData<AllRestaurantModel>()
    /* val clickCode= MutableLiveData<Int>()
     fun CodeControl(Code:Int){
     clickCode.value=Code
     }*/

    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }


    fun getRestaurantWithToken(token: String) {
        val BASE_URL = "http://apiyummy.wookweb.com/"
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ApiService::class.java)
        service.getRestaurants("Baerer " + token).enqueue(object : Callback<RestaurantModel> {
            override fun onFailure(call: Call<RestaurantModel>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application, "Error wile accessing the API", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<RestaurantModel>,
                response: Response<RestaurantModel>
            ) {
                Log.d("SearchRepository", "Response : ${Gson().toJson(response.body())}")
                restaurants.value = response.body()
                showProgress.value = false
            }

        })

    }

    fun getAllRestaurants(
        token: String,
        city: String,
        query: String,
        order: String,
        filter: ArrayList<String>
    ) {

        apiClient.getAllRestaurants("Bearer " + token, city, query, order, filter)
            .enqueue(object : Callback<AllRestaurantModel> {
                override fun onFailure(call: Call<AllRestaurantModel>, t: Throwable) {
                    Log.e("onfaiulere", t.message)
                }

                override fun onResponse(
                    call: Call<AllRestaurantModel>,
                    response: Response<AllRestaurantModel>
                ) {
                    Log.e("all restaurants", response.body().toString())
                    allRestaurants.value = response.body()

                }

            })


    }

    fun getPopularRestaurants(
        token: String,
        city: String,
        query: String,
        order: String,
        filter: ArrayList<String>
    ) {

        apiClient.getPopularRestaurants("Bearer " + token, city, query, order, filter)
            .enqueue(object : Callback<AllRestaurantModel> {
                override fun onFailure(call: Call<AllRestaurantModel>, t: Throwable) {
                    Log.e("onfaiulere", t.message)
                }

                override fun onResponse(
                    call: Call<AllRestaurantModel>,
                    response: Response<AllRestaurantModel>
                ) {
                    Log.e("popular restaurants", response.body().toString())
                    popularRestaurants.value = response.body()
                }

            })


    }

    fun getTopRestaurants(
        token: String,
        city: String,
        query: String,
        order: String,
        filter: ArrayList<String>
    ) {

        apiClient.getTopRestaurants("Bearer " + token, city, query, order, filter)
            .enqueue(object : Callback<AllRestaurantModel> {
                override fun onFailure(call: Call<AllRestaurantModel>, t: Throwable) {
                    Log.e("onfaiulere", t.message)
                }

                override fun onResponse(
                    call: Call<AllRestaurantModel>,
                    response: Response<AllRestaurantModel>
                ) {
                    Log.e("top", response.body().toString())
                    topRestaurants.value = response.body()
                }

            })


    }


}