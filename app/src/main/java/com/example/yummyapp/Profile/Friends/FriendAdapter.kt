package com.example.yummyapp.Profile.Friends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Profile.Friends.Model.Data
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_friends.view.*


class FriendAdapter(var List: List<Data>) : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_friends, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.image.setImageResource(R.drawable.profileimage)
        holder.name.text = List[position].user.name
        holder.yummuy_score.text = "45 Yummy"


    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var image = view.image
        var name = view.friend_name_tv
        var yummuy_score = view.yummy_score_tv

    }

}