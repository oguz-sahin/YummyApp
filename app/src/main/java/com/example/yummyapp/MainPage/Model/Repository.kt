package com.example.yummyapp.MainPage.Model

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Service.ApiService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Repository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val restaurants = MutableLiveData<RestaurantModel>()
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


}