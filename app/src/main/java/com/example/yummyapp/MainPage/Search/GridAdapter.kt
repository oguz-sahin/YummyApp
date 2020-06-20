package com.example.yummyapp.MainPage.Search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yummyapp.MainPage.Model.Data
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_grid.view.*


class GridAdapter(var List: List<Data>, var context: Context) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = List.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load("https://yummy.wookweb.com/assets/img/restoran/" + List[position].image)
            .into(holder.restaurant_iv)
        holder.restaurant_name_tv.text = List[position].name
        holder.kitchen_tv.text = List[position].kitchenType

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var restaurant_iv = view.iv as ImageView
        var restaurant_name_tv = view.restaurant_name_tv
        var status_tv = view.status_tv
        var kitchen_tv = view.kithcen_tv
        var ratingBar = view.ratingBar
        var rate_tv = view.rate_tv
        var km_tv = view.km_tv

    }

}