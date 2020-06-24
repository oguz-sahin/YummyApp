package com.example.yummyapp.MainPage.Restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yummyapp.MainPage.Model.Categories
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_menu.view.*


class CategoriesAdapter(var List: List<Categories>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.image.context)
            .load("https://yummy.wookweb.com/assets/img/categories/" + List[position].image)
            .into(holder.image)
        holder.category.text = List[position].name
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var image = view.category_image
        var category = view.category_tv

    }

}