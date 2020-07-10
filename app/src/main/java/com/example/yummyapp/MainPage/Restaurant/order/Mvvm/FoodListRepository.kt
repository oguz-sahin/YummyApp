package com.example.yummyapp.MainPage.Restaurant.order.Mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Restaurant.order.FoodListModel.FoodListModel
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import retrofit2.Callback
import retrofit2.Response

class FoodListRepository(application: Application) {

    val FoodList = MutableLiveData<FoodListModel>()


    fun getFoodList(token: String, restaurantId: String, categoryId: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.getFoodList(token, restaurantId, categoryId)
            .enqueue(object : Callback<FoodListModel> {
                override fun onFailure(call: retrofit2.Call<FoodListModel>, t: Throwable) {
                    Log.e("foodlist on faiuler", t.message)
                }

                override fun onResponse(
                    call: retrofit2.Call<FoodListModel>,
                    response: Response<FoodListModel>
                ) {
                    if (response.isSuccessful) {

                        FoodList.value = response.body()

                    } else {

                        Log.e("Foodlist else issucces", "else foodlist")


                    }


                }


            })


    }


}