package com.example.yummyapp.Profile.Friends

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.Profile.Friends.Model.FriendListModel
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_friends_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Friends_activity : AppCompatActivity() {


    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_activity)


        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")

        Log.e("token", token)


        /*Doğrusu*/ apiClient.getFriendList("Bearer " + token)
            .enqueue(object : Callback<FriendListModel> {
                override fun onFailure(call: Call<FriendListModel>, t: Throwable) {
                    Log.e("tag", t.message)
                }

                override fun onResponse(
                    call: Call<FriendListModel>,
                    response: Response<FriendListModel>
                ) {

                    Log.e("tag", response.body().toString())
                    recyclerview.layoutManager = LinearLayoutManager(this@Friends_activity)
                    recyclerview.adapter = FriendAdapter(response.body()!!.data)
                }


            })


        back.setOnClickListener { onBackPressed() }


    }
}
