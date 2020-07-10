package com.example.yummyapp.Sepetim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.R
import com.example.yummyapp.Sepetim.model.Food
import kotlinx.android.synthetic.main.item_basketcompletedetail.view.*

class BasketCompleteDetailAdapter(var List: List<Food>) :
    RecyclerView.Adapter<BasketCompleteDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_basketcompletedetail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var food_name = view.food_name_tv
        var option_name = view.option_name_tv
        var quantity = view.quantity_tv
        var price = view.price_tv


    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.food_name.text = List[position].info.name
        holder.quantity.text = "X" + List[position].quantity
        holder.option_name.text = List[position].details[0].name
        holder.price.text = List[position].price
    }


}
