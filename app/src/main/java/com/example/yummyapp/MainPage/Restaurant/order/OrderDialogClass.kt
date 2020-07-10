package com.example.yummyapp.MainPage.Restaurant.order

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.MainPage.Restaurant.order.FoodDetailModel.Option
import com.example.yummyapp.MainPage.Restaurant.order.Utill.CheckFoodItem
import com.example.yummyapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class OrderDialogClass(var Option: Option, var CheckFoodItem: CheckFoodItem) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = MaterialAlertDialogBuilder(activity)
        val view = activity?.layoutInflater?.inflate(R.layout.orderdialog, null)
        builder.setView(view)

        var rv = view?.findViewById<RecyclerView>(R.id.recyclerview)
        var tv = view?.findViewById<TextView>(R.id.textView27)

        rv?.adapter = DialogAdapter(Option.deger, Option.fiyat, Option.type, CheckFoodItem)
        rv?.layoutManager = LinearLayoutManager(context)


        return builder.create()
    }


}