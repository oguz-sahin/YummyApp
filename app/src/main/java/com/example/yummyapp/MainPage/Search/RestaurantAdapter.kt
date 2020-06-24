package com.example.yummyapp.MainPage.Search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yummyapp.MainPage.Model.Data
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_list.view.*

class RestaurantAdapter(var List: List<Data>, var itemClick: itemClick) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("url", "https://yummy.wookweb.com/assets/img/restoran/" + List[position].image)

        // Picasso.get().load("http://yummy.wookweb.com/assets/restoran.jpg").into(holder.image)
        Glide.with(holder.image.context)
            .load("https://yummy.wookweb.com/assets/img/restoran/" + List[position].image)
            .into(holder.image)
        holder.restaurant_name_tv.text = List[position].name

        if (List[position].kitchenType == "4") {
            holder.kitchen_tv.text = "Türk Mutfağı"
        }


        holder.itemView.setOnClickListener {

            itemClick.click(List[position])

        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.item_list_iv
        var restaurant_name_tv = view.restaurant_name_tv
        var kitchen_tv = view.kithcen_tv
        var status = view.status_tv
        var rate = view.ratingBar
        var rate_tv = view.rate_tv


    }

}
