package com.example.yummyapp.MainPage.Restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.MainPage.Model.Comment
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_comments.view.*


class CommentAdapter(var List: List<Comment>) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_comments, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        /* val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
         val date=formatter.parse(List[position].date)
         date.toString()*/
        var avarage =
            List[position].service.toFloat() + List[position].food.toFloat() + List[position].location.toFloat() + List[position].price.toFloat()
        avarage.div(3)

        holder.comment.text = List[position].text
        // Glide.with(holder.user_image.context).load("https://yummy.wookweb.com/assets/img/comments/" + List[position].images).into(holder.user_image)
        holder.user_image.setImageResource(R.drawable.profileimage)
        holder.user_name.text = List[position].title
        holder.user_rate.rating = avarage
        holder.date.text = List[position].date


    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var user_image = view.user_iv
        var user_name = view.user_name_tv
        var user_rate = view.user_ratingBar
        var date = view.day_tv
        var comment = view.comment_tv

    }

}