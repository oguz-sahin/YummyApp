package com.example.yummyapp.MainPage.Restaurant.order

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.MainPage.Restaurant.order.Utill.CheckFoodItem
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.item_orderdialog.view.*

class DialogAdapter(
    var degerList: List<String>,
    var fiyatList: List<String>,
    var type: String,
    var checkedFoodItem: CheckFoodItem
) : RecyclerView.Adapter<DialogAdapter.ViewHolder>() {

    var optionalCheckedList = ArrayList<returnFoodModel>()
    var forcedCheckedList = ArrayList<String>()
    private var checkedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_orderdialog, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return degerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("size", degerList.size.toString())
        Log.e("dizi", degerList.toString())
        holder.option_tv.text = degerList[position]
        holder.cb.text = fiyatList[position] + "TL"

        holder.cb.isChecked = checkedPosition == position

        holder.itemView.setOnClickListener {
            if (type == "0") {
                Log.e("type", type)


                if (holder.cb.isChecked) {

                    var deger = degerList[position]
                    var fiyat = fiyatList[position]
                    Log.e("deger", deger)
                    Log.e("fiyat", fiyat)

                    optionalCheckedList.add(returnFoodModel(deger, fiyat))
                    Log.e("optionList", optionalCheckedList.get(0).foodName)
                    checkedFoodItem.ChekedFood(optionalCheckedList)

                } else {
                    optionalCheckedList.removeAt(position)
                    Log.e("optionLista", optionalCheckedList.toString())
                    checkedFoodItem.ChekedFood(optionalCheckedList)
                }
            } else {


                for (i in 0 until degerList.size) {


                }
                Log.e("tag", "zorunlu")


                /*  if (isChecked){

                      forcedCheckedList.add(fiyatList[position])
                      Log.e("forcedList",forcedCheckedList.toString())

                  }else{

                      forcedCheckedList.remove(fiyatList[position])
                      Log.e("forcedList",forcedCheckedList.toString())
                  }*/

            }

        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var option_tv = view.option_name_tv
        var cb = view.cb


    }

}