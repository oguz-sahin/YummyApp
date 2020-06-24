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
import com.example.yummyapp.Constans
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(requireActivity()).get(restaurantViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false)
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


        vm.getRestauranComments(token!!, id)
        vm.restaurantComment.observe(activity!!, Observer {

            Log.e("commentasd", it.data.toString())
            recyclerview.layoutManager = LinearLayoutManager(activity)
            recyclerview.adapter = CommentAdapter(it.data)


        })



        materialButton2.setOnClickListener {

            startActivity(Intent(this.activity, MakeCommentActivity::class.java))


        }


    }


}
