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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Restaurant.Mvvm.restaurantViewModel
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_comment.*

/**
 * A simple [Fragment] subclass.
 */
class CommentFragment : Fragment() {
    private lateinit var vm: restaurantViewModel
    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(requireActivity()).get(restaurantViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comment, container, false)
        rv = view.findViewById(R.id.recyclerview)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //RestaurantId
        val prefences =
            activity?.getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val restaurantId = prefences?.getString(Constans.RestaurantID, "0")


        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")




        vm.getRestauranComments(token!!, restaurantId!!)
        vm.restaurantComment.observe(activity!!, Observer {

            Log.e("commentasd", it.data.toString())
            rv.layoutManager = LinearLayoutManager(activity)
            rv.adapter = CommentAdapter(it.data)


        })



        materialButton2.setOnClickListener {

            startActivity(Intent(this.activity, MakeCommentActivity::class.java))


        }


    }


}
