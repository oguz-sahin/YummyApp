package com.example.yummyapp.Register

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RegisterApiClient {

    const val BASE_URL = "http://apiyummy.wookweb.com/"

    fun getApiClient(): RegisterApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RegisterApiService::class.java)
    }


}