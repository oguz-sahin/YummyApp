package com.example.yummyapp.Profile.Friends

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Profile.Friends.Model.User
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_addfriend.view.*


class AddFriendAdapter(var List: ArrayList<User>, var ItemCheck: ItemCheck) :
    RecyclerView.Adapter<AddFriendAdapter.ViewHolder>(), Filterable {

    var CheckedList = ArrayList<User>()
    var UserFilteredList = ArrayList<User>(List)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_addfriend, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.image.setImageResource(R.drawable.profileimage)
        holder.name.text = List[position].name
        holder.cb.setOnClickListener {

            if (holder.cb.isChecked) {
                Log.e("cb", List[position].name)
                CheckedList.add(List[position])
                Log.e("cb", CheckedList.toString())
                ItemCheck.ItemCheck(CheckedList)
            } else {
                CheckedList.remove(List[position])
                Log.e("cb", CheckedList.toString())
                ItemCheck.ItemCheck(CheckedList)
            }

        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var image = view.image
        var name = view.friend_name_tv
        var yummuy_score = view.yummy_score_tv
        var cb = view.checkbox

    }

    override fun getFilter(): Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = ArrayList<User>()
            if (constraint == null || constraint.isEmpty()) {

                filteredList.addAll(UserFilteredList)
            } else {

                val filteredPattern = constraint.toString().toLowerCase().trim()

                for (user: User in UserFilteredList) {

                    val name = user.name
                    if (name.toLowerCase().contains(filteredPattern)) {

                        filteredList.add(user)
                    }


                }

            }
            return FilterResults().apply { values = filteredList }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            List.clear()
            List.addAll(results?.values as ArrayList<User>)
            notifyDataSetChanged()
        }


    }

}