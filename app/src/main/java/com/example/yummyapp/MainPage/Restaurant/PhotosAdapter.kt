package com.example.yummyapp.MainPage.Restaurant

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yummyapp.MainPage.Model.Photo
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_about.view.*

class PhotosAdapter(
    var List: List<Photo>,
    var context: Context,
    var itemClickPhoto: itemClickPhoto
) :
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_about, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("image", "https://yummy.wookweb.com/assets/img/restoran/" + List[position].image)
        Glide.with(holder.iv.context)
            .load("https://yummy.wookweb.com/assets/img/restoran/" + List[position].image)
            .dontAnimate().into(holder.iv)
        holder.itemView.setOnClickListener {
            itemClickPhoto.İtemClick()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var iv = view.iv

    }

}