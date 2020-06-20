package com.example.yummyapp.MainPage.Search

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.RestaurantModel
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    private lateinit var adapter: TabAdapter
    lateinit var model: viewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        val apiClient: ApiService = ApiClient.getApiClient()
        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")

        val codePref = getSharedPreferences(Constans.PREFS_ClickCode, Context.MODE_PRIVATE)
        val editor = codePref.edit()
        editor.putInt(Constans.Code_KEY_NAME, 1)
        editor.commit()


        adapter = TabAdapter(supportFragmentManager)

        adapter.apply {
            addFragment(nearFragmet(), "Yakınımda")
            addFragment(AllFragment(), "Tümü")
            addFragment(PopularFragment(), "En Popüler")
            addFragment(LikedFragment(), "En Beğenilenler")
        }
        view_pager.adapter = adapter
        tabLayout.setupWithViewPager(view_pager)

        apiClient.getRestaurants("Baerer " + token)
            .enqueue(object : Callback<MutableLiveData<RestaurantModel>> {

                override fun onFailure(call: Call<MutableLiveData<RestaurantModel>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<MutableLiveData<RestaurantModel>>,
                    response: Response<MutableLiveData<RestaurantModel>>
                ) {

                    if (response.isSuccessful) {
                        if (response.body().hasObservers()) {

                        } else {

                            Log.e("tag", "status false")

                        }

                    } else {

                        Log.e("tag", "response not succes")
                    }

                }

            })


        grid_icon.setOnClickListener {
            editor.putInt(Constans.Code_KEY_NAME, 1)
            editor.commit()
        }
        list_icon.setOnClickListener {
            editor.putInt(Constans.Code_KEY_NAME, 2)
            editor.commit()
            val prefences = getSharedPreferences(Constans.PREFS_ClickCode, Context.MODE_PRIVATE)
            val code = prefences.getInt(Constans.Code_KEY_NAME, 1)

        }

    }
}
