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
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.Data
import com.example.yummyapp.MainPage.Model.RestaurantModel
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.MainPage.Restaurant.restaurantActivity
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LikedFragment : Fragment(), itemClick {
    private lateinit var vm: viewModel
    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }
    private lateinit var rv: RecyclerView
    private var code: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_liked, container, false)
        rv = view.findViewById(R.id.recyclerview) as RecyclerView

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

        vm.Code.observe(requireActivity(), Observer {
            code = it

        })

        Log.e("code Liked", code.toString())
        apiClient.getRestaurants("Baerer " + token).enqueue(object : Callback<RestaurantModel> {
            override fun onFailure(call: Call<RestaurantModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<RestaurantModel>,
                response: Response<RestaurantModel>
            ) {
                if (code == 1) {
                    rv.layoutManager = GridLayoutManager(activity, 2)
                    Log.e("like", response.body()?.data.toString())
                    var response = response.body()?.data
                    rv.adapter = GridAdapter(response!!, activity!!, this@LikedFragment)
                } else if (code == 2) {
                    rv.layoutManager = LinearLayoutManager(activity)
                    rv.adapter = RestaurantAdapter(response.body()!!.data, this@LikedFragment)

                }

            }
        })


        /*  vm.restaurants.observe(requireActivity(), Observer {
              var response=it
              Log.e("liked response",response.data.toString())
              val code=1

              it.let {
                  if (code==1){
                      recyclerview.layoutManager=GridLayoutManager(activity,2)
                      Log.e("it",response.data.toString())
                      recyclerview.adapter=GridAdapter(response.data,activity!!,this)
                  }else if (code==2){
                      recyclerview.layoutManager= LinearLayoutManager(activity)
                      recyclerview.adapter=RestaurantAdapter(response.data)
                  }
              }

          })

  */


    }


    override fun click(Code: Data) {
        val intent = Intent(activity, restaurantActivity::class.java)
        intent.putExtra(Constans.ClickRestaurant, Code)
        startActivity(intent)
    }


}