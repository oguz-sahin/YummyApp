package com.example.yummyapp.Sepetim

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.MainPage.Model.Basket
import com.example.yummyapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.item_basket.view.*


class BasketAdapter(var List: MutableList<Basket>, var basketItemClick: BasketItemClick) :
    RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basket, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    fun notifyEditItem(activity: Activity, context: Context, position: Int) {

        notifyItemChanged(position) // Notify any registered observers that the item at position has changed.
    }


    fun notifyDeleteItem(
        context: Context,
        activity: FragmentActivity,
        Position: Int,
        token: String
    ) {


        val vm = ViewModelProvider(activity).get(BasketViewModel::class.java)

        val builder = MaterialAlertDialogBuilder(context)
            .setBackground(context.getDrawable(R.drawable.alert_shape))
            .setTitle("Silme Onayı")
            .setMessage("Sepeti Silmek istediğinize emin misiniz?")
            .setIcon(R.drawable.ic_delete)
            .setNegativeButton("Hayır", { dialog, which ->

                dialog.dismiss()
                notifyItemChanged(Position)

            })
            .setPositiveButton("Evet", { dialog, which ->
                vm.DeleteBasket(token, List[Position].restaurantİd!!)
                List.removeAt(Position)
                notifyItemRemoved(Position)
            })
        val dialog = builder.create()
        dialog.show()

        //notifyItemRemoved(Position)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.restaurant_name.text = List[position].name
        holder.price.text = List[position].price

        holder.itemView.setOnClickListener {
            basketItemClick.itemClick(List[position].restaurantİd!!)
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var restaurant_name = view.restaurant_name_tv
        var price = view.price_tv

    }

}