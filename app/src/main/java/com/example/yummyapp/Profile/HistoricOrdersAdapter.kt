package com.example.yummyapp.Profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Profile.Model.DataHistoric
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_pastorder.view.*

class HistoricOrdersAdapter(var List: List<DataHistoric>) :
    RecyclerView.Adapter<HistoricOrdersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pastorder, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.restauran_name.text = List[position].name
        holder.status.text = List[position].status
        holder.pin.text = "Pin: " + List[position].pin
        holder.price.text = List[position].price

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val restauran_name = view.restaurant_name_tv
        val status = view.status_tv
        val pin = view.pin_tv
        val price = view.price_tv


    }

}