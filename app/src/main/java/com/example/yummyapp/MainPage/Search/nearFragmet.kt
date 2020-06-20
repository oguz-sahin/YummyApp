package com.example.yummyapp.MainPage.Search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.RestaurantModel
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_near_fragmet.*


class nearFragmet : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_near_fragmet, container, false)
        var RestaurantModel =
            arguments?.getSerializable(Constans.RestaurantModel) as RestaurantModel
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val prefences =
            activity?.getSharedPreferences(Constans.PREFS_ClickCode, Context.MODE_PRIVATE)
        val code = prefences?.getInt(Constans.Code_KEY_NAME, 1)

        if (code == 1) {
            recyclerview.adapter = GridAdapter(RestaurantModel.data, activity!!)
            recyclerview.layoutManager = GridLayoutManager(activity, 2)
        } else if (code == 2) {
            recyclerview.adapter = RestaurantAdapter(RestaurantModel.data, activity!!)
            recyclerview.layoutManager = LinearLayoutManager(activity)
        }

    }


}
