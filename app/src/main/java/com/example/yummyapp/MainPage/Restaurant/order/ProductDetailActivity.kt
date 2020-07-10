package com.example.yummyapp.MainPage.Restaurant.order

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Restaurant.Mvvm.FoodDetailViewModel
import com.example.yummyapp.MainPage.Restaurant.order.FoodDetailModel.Option
import com.example.yummyapp.MainPage.Restaurant.order.Utill.CheckFoodItem
import com.example.yummyapp.MainPage.Restaurant.order.Utill.ItemClickType
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity(), ItemClickType, CheckFoodItem {

    private lateinit var vm: FoodDetailViewModel
    var icons = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)


        val foodId = intent.getStringExtra(Constans.food_id)

        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")

        vm = ViewModelProvider(this).get(FoodDetailViewModel::class.java)

        vm.getFoodDetails(token!!, foodId)

        vm.foodDetails.observe(this, Observer {

            Log.e("detail food", it.data.toString())
            if (it.data.vegan == "1") icons.add("http://yummy.wookweb.com/assets/img/vegan.png")
            if (it.data.pigMeat == "1") icons.add("http://yummy.wookweb.com/assets/img/pig.png")
            if (it.data.gluten == "1") icons.add("http://yummy.wookweb.com/assets/img/gluten.png")
            if (it.data.hot == "1") icons.add("http://yummy.wookweb.com/assets/img/hot.png")
            if (it.data.organic == "1") icons.add("http://yummy.wookweb.com/assets/img/organic.png")

            Log.e("icon", icons.toString())

            if (icons.size == 1) {
                Glide.with(iconone.context).load(icons[0]).into(iconone)
            } else if (icons.size == 2) {
                Glide.with(iconone.context).load(icons[0]).into(iconone)
                Glide.with(icontwo.context).load(icons[1]).into(icontwo)
            } else if (icons.size == 3) {
                Glide.with(iconone.context).load(icons[0]).into(iconone)
                Glide.with(icontwo.context).load(icons[1]).into(icontwo)
                Glide.with(iconthree.context).load(icons[2]).into(iconthree)
            } else if (icons.size == 4) {
                Glide.with(iconone.context).load(icons[0]).into(iconone)
                Glide.with(icontwo.context).load(icons[1]).into(icontwo)
                Glide.with(iconthree.context).load(icons[2]).into(iconthree)
                Glide.with(iconfour.context).load(icons[3]).into(iconfour)
            } else if (icons.size == 5) {
                Glide.with(iconone.context).load(icons[0]).into(iconone)
                Glide.with(icontwo.context).load(icons[1]).into(icontwo)
                Glide.with(iconthree.context).load(icons[2]).into(iconthree)
                Glide.with(iconfour.context).load(icons[3]).into(iconfour)
                Glide.with(iconfive.context).load(icons[4]).into(iconfive)
            }

            Glide.with(this)
                .load("http://yummy.wookweb.com/assets/img/food/" + it.data.id + "/" + it.data.image)
                .into(food_detail_iv)
            food_name_tv.text = it.data.name
            calori_tv.text = it.data.calorie + " Kalori"
            preparation_time_tv.text = it.data.preparationTime + " dk hazırlanma süresi"


            back.setOnClickListener { onBackPressed() }

            recyclerview.layoutManager = LinearLayoutManager(this)
            recyclerview.adapter =
                FoodDetailAdapter(it.data.options, this@ProductDetailActivity, this)


        })


    }

    override fun ItemClick(Options: Option) {

        val dialog = OrderDialogClass(Options, this)
        dialog.show(supportFragmentManager, "tag")

    }

    override fun ChekedFood(checkedFoodList: ArrayList<returnFoodModel>) {

        Log.e("tag", checkedFoodList.toString())
    }


}
