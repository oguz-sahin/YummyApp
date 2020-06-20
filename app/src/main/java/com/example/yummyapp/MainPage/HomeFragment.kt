package com.example.yummyapp.MainPage

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.UserApi.ApiClient
import com.example.yummyapp.MainPage.UserApi.ApiService
import com.example.yummyapp.MainPage.UserApi.UserModel
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val prefences =
            this.activity?.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = prefences?.getString(Constans.KEY_NAME, "")
        Log.e("homefragmetoken", token)
        apiClient.getUserInformation("Bearer " + token).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.e("Fauilere", t.message)
            }

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                Log.e("user", response.body().toString())
                Log.e("status", response.body()?.status.toString())
                username_tv.text = response.body()?.data?.name
            }


        })




    }

}
