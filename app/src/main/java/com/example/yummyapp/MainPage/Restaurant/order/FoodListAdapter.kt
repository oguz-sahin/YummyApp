package com.example.yummyapp.MainPage.Restaurant.order

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yummyapp.MainPage.Restaurant.order.FoodListModel.Data
import com.example.yummyapp.MainPage.Restaurant.order.Utill.ItemClickFood
import com.example.yummyapp.MainPage.Restaurant.order.Utill.iconModel
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_food.view.*

class FoodListAdapter(var List: List<Data>, var ItemClickFood: ItemClickFood) :
    RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    var icons = ArrayList<iconModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (List[position].vegan == "1") icons.add(
            iconModel(
                "http://yummy.wookweb.com/assets/img/vegan.png",
                "Vegan"
            )
        )
        if (List[position].pigMeat == "1") icons.add(
            iconModel(
                "http://yummy.wookweb.com/assets/img/pig.png",
                "Domuz eti içermez"
            )
        )
        if (List[position].gluten == "1") icons.add(
            iconModel(
                "http://yummy.wookweb.com/assets/img/gluten.png",
                "Gluten içermez"
            )
        )
        if (List[position].hot == "1") icons.add(
            iconModel(
                "http://yummy.wookweb.com/assets/img/hot.png",
                "Acılı"
            )
        )
        if (List[position].organic == "1") icons.add(
            iconModel(
                "http://yummy.wookweb.com/assets/img/organic.png",
                "Organik"
            )
        )

        Log.e("icon", icons.toString())

        if (icons.size == 1) {
            Glide.with(holder.iconone.context).load(icons[0].imageUrl).into(holder.iconone)
            holder.iconone.tooltipText = icons[0].tooltipText
        } else if (icons.size == 2) {
            Glide.with(holder.iconone.context).load(icons[0].imageUrl).into(holder.iconone)
            Glide.with(holder.icontwo.context).load(icons[1].imageUrl).into(holder.icontwo)
            holder.iconone.tooltipText = icons[0].tooltipText
            holder.icontwo.tooltipText = icons[1].tooltipText
        } else if (icons.size == 3) {
            Glide.with(holder.iconone.context).load(icons[0].imageUrl).into(holder.iconone)
            Glide.with(holder.icontwo.context).load(icons[1].imageUrl).into(holder.icontwo)
            Glide.with(holder.iconthree.context).load(icons[2].imageUrl).into(holder.iconthree)
            holder.iconone.tooltipText = icons[0].tooltipText
            holder.icontwo.tooltipText = icons[1].tooltipText
            holder.iconthree.tooltipText = icons[2].tooltipText
        } else if (icons.size == 4) {
            Glide.with(holder.iconone.context).load(icons[0].imageUrl).into(holder.iconone)
            Glide.with(holder.icontwo.context).load(icons[1].imageUrl).into(holder.icontwo)
            Glide.with(holder.iconthree.context).load(icons[2].imageUrl).into(holder.iconthree)
            Glide.with(holder.iconfour.context).load(icons[3].imageUrl).into(holder.iconfour)
            holder.iconone.tooltipText = icons[0].tooltipText
            holder.icontwo.tooltipText = icons[1].tooltipText
            holder.iconthree.tooltipText = icons[2].tooltipText
            holder.iconfour.tooltipText = icons[3].tooltipText
        } else if (icons.size == 5) {
            Glide.with(holder.iconone.context).load(icons[0].imageUrl).into(holder.iconone)
            Glide.with(holder.icontwo.context).load(icons[1].imageUrl).into(holder.icontwo)
            Glide.with(holder.iconthree.context).load(icons[2].imageUrl).into(holder.iconthree)
            Glide.with(holder.iconfour.context).load(icons[3].imageUrl).into(holder.iconfour)
            Glide.with(holder.iconfive.context).load(icons[4].imageUrl).into(holder.iconfive)
            holder.iconone.tooltipText = icons[0].tooltipText
            holder.icontwo.tooltipText = icons[1].tooltipText
            holder.iconthree.tooltipText = icons[2].tooltipText
            holder.iconfour.tooltipText = icons[3].tooltipText
            holder.iconfive.tooltipText = icons[4].tooltipText

        }

        icons.clear()
        holder.food_name.text = List[position].name
        Glide.with(holder.image.context)
            .load("http://yummy.wookweb.com/assets/img/food/" + List[position].id + "/" + List[position].image)
            .into(holder.image)
        holder.price_tv.text = "${List[position].price} TL"

        holder.add_button.setOnClickListener {

            ItemClickFood.ClikFoodItem(List[position])

        }


    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var image = view.image
        var food_name = view.food_name_tv
        var price_tv = view.price_tv
        var iconone = view.iconone
        var icontwo = view.icontwo
        var iconthree = view.iconthree
        var iconfour = view.iconfour
        var iconfive = view.iconfive
        var add_button = view.add_button

    }

}