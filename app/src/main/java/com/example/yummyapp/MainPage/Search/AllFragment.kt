package com.example.yummyapp.MainPage.Search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.Data
import com.example.yummyapp.MainPage.Model.RestaurantModel
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.MainPage.Restaurant.restaurantActivity
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_all.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllFragment : Fragment(), itemClick {
    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }
    private lateinit var vm: viewModel
    private var code = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(activity!!).get(viewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")
        vm.getRestaurantsWithToken("Bearer " + token)

        vm.Code.observe(activity!!, Observer {
            code = it
            Log.e("tümü code", it.toString())
        })

        apiClient.getRestaurants("Baerer " + token).enqueue(object : Callback<RestaurantModel> {
            override fun onFailure(call: Call<RestaurantModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<RestaurantModel>,
                response: Response<RestaurantModel>
            ) {
                recyclerview.layoutManager = GridLayoutManager(activity, 2)
                Log.e("it", response.body()?.data.toString())
                recyclerview.adapter =
                    GridAdapter(response.body()!!.data, activity!!, this@AllFragment)
            }


        })

    }


    override fun click(Code: Data) {
        val intent = Intent(activity, restaurantActivity::class.java)
        intent.putExtra(Constans.ClickRestaurant, Code)
        startActivity(intent)
    }

}
