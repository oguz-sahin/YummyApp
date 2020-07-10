package com.example.yummyapp.Sepetim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_basketdetailproduct.view.*


class BasketDetailAdapter(var List: List<Data>) :
    RecyclerView.Adapter<BasketDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_basketdetailproduct, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.food_name.text = List[position].name
        holder.quantity.text = "X" + List[position].quantity
        holder.option_name.text = List[position].details[0].name
        holder.price.text = List[position].price

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var food_name = view.food_name_tv
        var option_name = view.option_name_tv
        var quantity = view.quantity_tv
        var price = view.price_tv


    }

}
