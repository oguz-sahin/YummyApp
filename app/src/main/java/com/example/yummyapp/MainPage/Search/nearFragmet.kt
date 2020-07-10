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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.AllRestaurantData
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.MainPage.Restaurant.restaurantActivity
import com.example.yummyapp.R


class nearFragmet(var searchWord: String) : Fragment(), itemClick {


    private lateinit var vm: viewModel
    private lateinit var rv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_near_fragmet, container, false)
        rv = view.findViewById(R.id.recyclerview)
        return view
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(activity!!).get(viewModel::class.java)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        Log.e("searchWord near", searchWord)


        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")

        val arrayList = ArrayList<String>()
        arrayList.add("0")
        arrayList.add("4")

        vm.getAllRestaurants(token!!, "istanbul", searchWord, "asc", arrayList)

        vm.allRestaurants.observe(activity!!, Observer {
            rv.layoutManager = GridLayoutManager(activity, 2)
            Log.e("it", it.data.toString())
            rv.adapter =
                GridAdapter(it.data, activity!!, this)

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
