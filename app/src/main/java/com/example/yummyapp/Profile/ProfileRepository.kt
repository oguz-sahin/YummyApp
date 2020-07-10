package com.example.yummyapp.Profile

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.Profile.Model.FavoriteRestaurantModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileRepository(application: Application) {

    val apiClient: ApiService by lazy { ApiClient.getApiClient() }

    val favoriteRestaurant = MutableLiveData<FavoriteRestaurantModel>()


    fun getFavoriteRestaurant(token: String) {


        apiClient.getFavoriteRestaurants("Bearer " + token)
            .enqueue(object : Callback<FavoriteRestaurantModel> {
                override fun onFailure(call: Call<FavoriteRestaurantModel>, t: Throwable) {
                    Log.e("onfailure favorite", t.message)
                }

                override fun onResponse(
                    call: Call<FavoriteRestaurantModel>,
                    response: Response<FavoriteRestaurantModel>
                ) {

                    if (response.isSuccessful) {


                        favoriteRestaurant.value = response.body()

                    }

                }


            })

    }


}