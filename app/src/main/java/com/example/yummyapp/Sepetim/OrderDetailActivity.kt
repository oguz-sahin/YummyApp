package com.example.yummyapp.Sepetim

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Constans
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.activity_order_information.backbutton

class OrderDetailActivity : AppCompatActivity() {


    lateinit var vm: BasketViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        val orderId = intent.getIntExtra("order_id", 0)
        Log.e("order_id", orderId.toString())

        var rv = findViewById<RecyclerView>(R.id.recyclerview)

        vm = ViewModelProvider(this).get(BasketViewModel::class.java)
        val prefences = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = prefences?.getString(Constans.KEY_NAME, "")

        vm.getCompleteBasketDetail(token!!, orderId.toString())
        vm.basketCompleteDetailModel.observe(this, Observer {


            date_tv.text = it.data.date
            time_tv.text = it.data.time
            pin_tv.text = it.data.pin
            status_tv.text = it.data.status
            price_tv.text = it.data.price

            rv.adapter = BasketCompleteDetailAdapter(it.data.foods)
            rv.layoutManager = LinearLayoutManager(this)


        })


        backbutton.setOnClickListener { onBackPressed() }
    }
}
