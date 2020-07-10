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
import com.example.yummyapp.MainPage.Model.AllRestaurantData
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.MainPage.Restaurant.restaurantActivity
import com.example.yummyapp.R


class PopularFragment(var searchWord: String) : Fragment(), itemClick {
    private lateinit var vm: viewModel
    private lateinit var rv: RecyclerView
    var code = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_popular, container, false)

        rv = view.findViewById(R.id.recyclerview)

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

        Log.e("searchWord popular", searchWord)



        vm.Code.observe(requireActivity(), Observer {
            code = it

            val array = ArrayList<String>()
            array.add("0")
            array.add("4")
            Log.e("array", array.toString())

            vm.getPopularestaurants(token!!, "istanbul", searchWord, "asc", array)

            vm.popularRestaurants.observe(this.activity!!, Observer {

                if (code == 1) {
                    rv.layoutManager = GridLayoutManager(activity, 2)
                    Log.e("popular", it.data.toString())
                    var response = it.data
                    rv.adapter = GridAdapter(response, activity!!, this@PopularFragment)
                } else if (code == 2) {
                    rv.layoutManager = LinearLayoutManager(activity)
                    rv.adapter =
                        RestaurantAdapter(it.data, this@PopularFragment)

                }

            })


        })

    }

    override fun click(Restaurant: AllRestaurantData) {

        val prefences =
            activity?.getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val editor = prefences?.edit()
        editor?.putString(Constans.RestaurantID, Restaurant.id)
        editor?.commit()

        val intent = Intent(activity, restaurantActivity::class.java)
        startActivity(intent)

    }

}
