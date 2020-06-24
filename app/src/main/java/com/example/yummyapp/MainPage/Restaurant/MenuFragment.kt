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
import kotlinx.android.synthetic.main.fragment_menu.*

private lateinit var vm: restaurantViewModel

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProviders.of(requireActivity()).get(restaurantViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = "as"
        vm.data.observe(requireActivity(), Observer {
            id = it.id
        })


        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")

        Log.e("id", id)

        vm.getRestaurantMenuCategories(id, token!!)
        vm.restaurantMenuCategories.observe(activity!!, Observer {

            Log.e("category resposne", it.data.toString())
            recyclerview.adapter = CategoriesAdapter(it.data)
            recyclerview.layoutManager = GridLayoutManager(activity, 2)


        })


    }

}
