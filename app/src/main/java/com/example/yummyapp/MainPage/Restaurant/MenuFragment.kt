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
import com.example.yummyapp.MainPage.Restaurant.order.FoodListActivity
import com.example.yummyapp.MainPage.Restaurant.order.Utill.ItemClick
import com.example.yummyapp.R

private lateinit var vm: restaurantViewModel
private lateinit var rv: RecyclerView
private var restaurantId = "as"

class MenuFragment : Fragment(), ItemClick {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        rv = view.findViewById(R.id.recyclerview)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProviders.of(requireActivity()).get(restaurantViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /* vm.data.observe(requireActivity(), Observer {
             restaurantId=it.id
         })*/

        //RestaurantId
        val prefences =
            activity?.getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val restaurantId = prefences?.getString(Constans.RestaurantID, "0")




        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")

        Log.e("id", restaurantId)

        vm.getRestaurantMenuCategories(restaurantId!!, token!!)
        vm.restaurantMenuCategories.observe(activity!!, Observer {

            Log.e("category resposne", it.data.toString())
            rv.adapter = CategoriesAdapter(it.data, this)
            rv.layoutManager = GridLayoutManager(activity, 2)


        })


    }

    override fun getId(CategoryId: String) {
        val intent = Intent(this.context, FoodListActivity::class.java)
        intent.putExtra(Constans.CategoryId, CategoryId)
        startActivity(intent)

    }


}
