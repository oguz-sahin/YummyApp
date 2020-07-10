package com.example.yummyapp.MainPage.Restaurant.Mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Model.CommentModelX
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MakeCommentRepository(application: Application) {
    val status = MutableLiveData<Boolean>()


    fun MakeComment(
        token: String,
        restaurantId: String,
        title: String,
        food_quality: Int,
        service: Int,
        location: Int,
        price: Int,
        comment: String
    ) {


        val apiClient: ApiService by lazy { ApiClient.getApiClient() }

        apiClient.PostComment(
            "Baerer " + token,
            restaurantId,
            title,
            food_quality,
            service,
            location,
            price,
            comment
        ).enqueue(object :
            Callback<CommentModelX> {
            override fun onFailure(call: Call<CommentModelX>, t: Throwable) {
                Log.e("make comment failere", t.message)
            }

            override fun onResponse(call: Call<CommentModelX>, response: Response<CommentModelX>) {

                if (response.isSuccessful) {
                    status.value = response.body()?.status
                } else {
                    Log.e("make commetn succses ", "is succesful else")


                }
            }


        })


    }


}