package com.example.yummyapp.MainPage.Restaurant.order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.MainPage.Restaurant.order.FoodDetailModel.Option
import com.example.yummyapp.MainPage.Restaurant.order.Utill.ItemClickType
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_option_forced.view.*

class FoodDetailAdapter(
    var List: List<Option>,
    var context: Context,
    var ItemClickType: ItemClickType
) : RecyclerView.Adapter<FoodDetailAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_option_forced, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (List[position].type == "1") holder.optiontv.text = List[position].baslik + "(Zorunlu)"
        else holder.optiontv.text = List[position].baslik + "(Zorunlu Değil)"

        holder.itemView.setOnClickListener {

            ItemClickType.ItemClick(List[position])
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var optiontv = view.option_tv

    }


}