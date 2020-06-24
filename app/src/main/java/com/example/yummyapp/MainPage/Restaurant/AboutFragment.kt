package com.example.yummyapp.MainPage.Restaurant

import android.content.Context
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
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_about.*

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {


    private lateinit var vm: restaurantViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProviders.of(requireActivity()).get(restaurantViewModel::class.java)
        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")


        vm.data.observe(requireActivity(), Observer {
            //Live data id alma fakat çalışmıyor
            Log.e("tag", it.id)


            vm.getRestaurantInformation(token!!, it.id)
            vm.restaurantResponse.observe(activity!!, Observer {

                restaurant_name_tv.text = it.data.name
                adress_tv.text = it.data.address
                phone_tv.text = it.data.phone


            })


            vm.getRestorantsPhotosWithToken(token, it.id)
            vm.restaurantPhotos.observe(activity!!, Observer {

                Log.e("tag", it.toString())
                recyclerview.adapter = PhotosAdapter(it.data, activity!!)
                recyclerview.layoutManager = GridLayoutManager(activity, 2)

            })


        })


    }

}
