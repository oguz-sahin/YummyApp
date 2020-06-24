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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.Data
import com.example.yummyapp.MainPage.Model.RestaurantModel
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.MainPage.Restaurant.restaurantActivity
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_popular.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class PopularFragment : Fragment(), itemClick {
    private lateinit var vm: viewModel
    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }
    private var code = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }


    override fun click(Code: Data) {
        val intent = Intent(activity, restaurantActivity::class.java)
        intent.putExtra(Constans.ClickRestaurant, Code)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        vm = ViewModelProviders.of(activity!!).get(viewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        vm.Code.observe(requireActivity(), Observer {
            code = it

        })

        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")
        vm.getRestaurantsWithToken("Bearer " + token)

        apiClient.getRestaurants("Baerer " + token).enqueue(object : Callback<RestaurantModel> {
            override fun onFailure(call: Call<RestaurantModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<RestaurantModel>,
                response: Response<RestaurantModel>
            ) {
                if (code == 1) {
                    recyclerview.layoutManager = GridLayoutManager(activity, 2)
                    Log.e("like", response.body()?.data.toString())
                    var response = response.body()?.data
                    recyclerview.adapter = GridAdapter(response!!, activity!!, this@PopularFragment)
                } else if (code == 2) {
                    recyclerview.layoutManager = LinearLayoutManager(activity)
                    recyclerview.adapter =
                        RestaurantAdapter(response.body()!!.data, this@PopularFragment)

                }
            }


        })


    }


}
