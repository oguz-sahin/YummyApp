package com.example.yummyapp.Profile

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummyapp.Constans
import com.example.yummyapp.R
import com.example.yummyapp.Sepetim.BasketViewModel
import kotlinx.android.synthetic.main.activity_historical.*

class historicalActivity : AppCompatActivity() {


    val vm: BasketViewModel by lazy { ViewModelProvider(this).get(BasketViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historical)


        val prefences = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = prefences?.getString(Constans.KEY_NAME, "")


        vm.getHistoricOrders(token!!)
        vm.historicOrders.observe(this, Observer {

            recyclerview.adapter = HistoricOrdersAdapter(it.data)
            recyclerview.layoutManager = LinearLayoutManager(this)


        })


    }
}
