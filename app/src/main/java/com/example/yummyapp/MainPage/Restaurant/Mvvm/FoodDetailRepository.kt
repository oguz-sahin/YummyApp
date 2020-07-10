package com.example.yummyapp.MainPage.Restaurant.Mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Restaurant.order.FoodDetailModel.FoodDetailModel
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDetailRepository(application: Application) {

    val foodDetails = MutableLiveData<FoodDetailModel>()


    fun getFoodDetail(token: String, foodId: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.getFoodDeatils(token, foodId).enqueue(object : Callback<FoodDetailModel> {
            override fun onFailure(call: Call<FoodDetailModel>, t: Throwable) {
                Log.e("onfauilere fooddetail", t.message)
            }

            override fun onResponse(
                call: Call<FoodDetailModel>,
                response: Response<FoodDetailModel>
            ) {
                if (response.isSuccessful) {

                    foodDetails.value = response.body()


                }


            }


        })


    }


}