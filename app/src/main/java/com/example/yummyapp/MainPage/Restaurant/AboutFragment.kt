package com.example.yummyapp.MainPage.Restaurant

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
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Restaurant.Mvvm.restaurantViewModel
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_about.*


class AboutFragment : Fragment(), itemClickPhoto {


    private lateinit var vm: restaurantViewModel
    private lateinit var rv: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        rv = view.findViewById(R.id.recyclerview)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProviders.of(requireActivity()).get(restaurantViewModel::class.java)
        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")


        //RestaurantId
        val prefences =
            activity?.getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val restaurantId = prefences?.getString(Constans.RestaurantID, "0")

        // val vm = ViewModelProviders.of(this).get(restaurantViewModel::class.java)


        vm.getRestaurantInformation(token!!, restaurantId!!)
            vm.restaurantResponse.observe(activity!!, Observer {

                restaurant_name_tv.text = it.data.name
                adress_tv.text = it.data.address
                phone_tv.text = it.data.phone


            })


        vm.getRestorantsPhotosWithToken(token, restaurantId)
            vm.restaurantPhotos.observe(activity!!, Observer {

                Log.e("tag", it.toString())
                rv.adapter = PhotosAdapter(it.data, activity!!, this)
                rv.layoutManager = GridLayoutManager(activity, 2)

            })


    }

    override fun İtemClick() {

        startActivity(Intent(this.activity, RestaurantPhotosActivity::class.java))

    }

}
