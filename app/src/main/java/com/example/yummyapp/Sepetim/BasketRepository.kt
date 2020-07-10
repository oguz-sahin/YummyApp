package com.example.yummyapp.Sepetim

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Model.BasketModel
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.Profile.Model.FavoriteRestaurantModel
import com.example.yummyapp.Profile.Model.HistoricOrderModel
import com.example.yummyapp.Sepetim.model.BasketCompleteDetailModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BasketRepository(application: Application) {

    val basket = MutableLiveData<BasketModel>()
    val deleteBasketModel = MutableLiveData<DeleteBasketModel>()
    val detailBasket = MutableLiveData<BasketProductDetailModel>()
    val basketCompleteResponse = MutableLiveData<BasketCompleteModel>()
    val basketCompleteDetailModel = MutableLiveData<BasketCompleteDetailModel>()
    val historicOders = MutableLiveData<HistoricOrderModel>()
    val favoriteRestaurant = MutableLiveData<FavoriteRestaurantModel>()


    fun getBasket(token: String) {


        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.getBasket("Bearer " + token).enqueue(object : Callback<BasketModel> {
            override fun onFailure(call: Call<BasketModel>, t: Throwable) {
                Log.e("fauilere basket", t.message)
            }

            override fun onResponse(call: Call<BasketModel>, response: Response<BasketModel>) {

                if (response.isSuccessful) {

                    Log.e("basket", response.body().toString())

                    if (response.body()!!.status) {

                        Log.e("tag", response.body().toString())
                        basket.value = response.body()
                    }


                }

            }


        })
    }


    fun deleteBasket(token: String, restaurantId: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.deleteBasket("Bearer " + token, restaurantId)
            .enqueue(object : Callback<DeleteBasketModel> {
                override fun onFailure(call: Call<DeleteBasketModel>, t: Throwable) {
                    Log.e("onfauilere deletebasket", t.message)
                }

                override fun onResponse(
                    call: Call<DeleteBasketModel>,
                    response: Response<DeleteBasketModel>
                ) {

                    if (response.isSuccessful) {

                        deleteBasketModel.value = response.body()

                    }

                }


            })


    }


    fun getBasketDetail(token: String, restaurantId: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.getBasketDetail("Bearer " + token, restaurantId)
            .enqueue(object : Callback<BasketProductDetailModel> {
                override fun onFailure(call: Call<BasketProductDetailModel>, t: Throwable) {
                    Log.e("onfaiuler basket detail", t.message)
                }

                override fun onResponse(
                    call: Call<BasketProductDetailModel>,
                    response: Response<BasketProductDetailModel>
                ) {
                    if (response.isSuccessful) {

                        if (response.body()!!.status) {

                            Log.e("detailbasket", response.body().toString())

                            detailBasket.value = response.body()

                        }
                    }

                }

            })


    }


    fun completeBasket(token: String, restaurantId: String, time: String, day: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.completeBasket("Bearer " + token, restaurantId, day, time)
            .enqueue(object : Callback<BasketCompleteModel> {
                override fun onFailure(call: Call<BasketCompleteModel>, t: Throwable) {
                    Log.e("fauilere complete", t.message)
                }

                override fun onResponse(
                    call: Call<BasketCompleteModel>,
                    response: Response<BasketCompleteModel>
                ) {
                    basketCompleteResponse.value = response.body()
                }


            })


    }


    fun getCompleteBasketDetail(token: String, id: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.getCompleteBasketDetail("Bearer " + token, id)
            .enqueue(object : Callback<BasketCompleteDetailModel> {
                override fun onFailure(call: Call<BasketCompleteDetailModel>, t: Throwable) {
                    Log.e("onfauler completedetail", t.message)
                }

                override fun onResponse(
                    call: Call<BasketCompleteDetailModel>,
                    response: Response<BasketCompleteDetailModel>
                ) {
                    Log.e("completebasketdetail", response.body().toString())
                    basketCompleteDetailModel.value = response.body()

                }


            })


    }


    fun getHistoricOrder(token: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }
        apiClient.getHistoricOrders("Bearer " + token)
            .enqueue(object : Callback<HistoricOrderModel> {
                override fun onFailure(call: Call<HistoricOrderModel>, t: Throwable) {
                    Log.e("on failuer historic", t.message)
                }

                override fun onResponse(
                    call: Call<HistoricOrderModel>,
                    response: Response<HistoricOrderModel>
                ) {


                    if (response.isSuccessful) {
                        historicOders.value = response.body()

                    } else {

                        Log.e("tag", "historic sre")

                    }


                }


            })


    }

    fun getFavoriteRestaurant(token: String) {

        val apiClient: ApiService by lazy { ApiClient.getApiClient() }
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
                        Log.e("tag", response.body().toString())

                    }

                }


            })

    }


}