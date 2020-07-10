package com.example.yummyapp.Sepetim

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummyapp.Constans
import com.example.yummyapp.R
import com.google.android.material.chip.Chip
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_order_information.*
import java.util.*
import kotlin.collections.ArrayList

class OrderInformationActivity : AppCompatActivity() {

    lateinit var vm: BasketViewModel
    var orderId = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_information)

        vm = ViewModelProvider(this).get(BasketViewModel::class.java)
        val hours = arrayOf(12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23)
        val minutes = arrayOf("00", "30")
        val c = Calendar.getInstance()
        val currentTime = c.time
        var list = ArrayList<String>()

        for (i in 0 until hours.size) {


        }

        /*  val hour=c.get(Calendar.HOUR_OF_DAY)
          val minute=c.get(Calendar.MINUTE) */


        val staticarray = arrayOf<String>(
            "12:00",
            "12:30",
            "13:00",
            "13:30",
            "14:00",
            "14:30",
            "15:00",
            "15:30",
            "16:00",
            "16:30",
            "17:00",
            "17:30",
            "18:00",
            "18:30",
            "19:00",
            "19:30",
            "20:00",
            "20:30",
            "21:00",
            "21:30",
            "22:30",
            "23:00"
        )
        val restauranId = intent.getStringExtra(Constans.sepetId)
        Log.e("tag", restauranId)

        val prefences = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = prefences?.getString(Constans.KEY_NAME, "")



        vm.getBasketDetail(token!!, restauranId)
        vm.detailBasket.observe(this, Observer {

            recyclerview.layoutManager = LinearLayoutManager(this)
            recyclerview.adapter = BasketDetailAdapter(it.data)


        })


        time_button.setOnClickListener {

            val builder = MaterialAlertDialogBuilder(this)
            builder.setTitle("Saat Seçiniz")

            builder.setItems(staticarray) { dialog, which ->
                Log.e("saat", staticarray[which])
                time_button.text = staticarray[which]

            }
            val dialog = builder.create()
            dialog.show()
            /*  val tp=TimePicker()
              tp.show(supportFragmentManager,"timepicker")*/

            /* if (answertwo==null){
                 val builder = MaterialAlertDialogBuilder(this)
                 builder.setTitle("Mesaj")
                 builder.setMessage("Lütfen Saat Seçiniz")
                 builder.background = resources.getDrawable(R.drawable.alert_shape, null)
                 builder.setPositiveButton("Tamam", { dialog, which ->

                     dialog.dismiss()
                 })
                 val dialog = builder.create()
                 dialog.show()

             }else{

                 if (answertwo.text.toString()=="Yarın"){
                     val builder=MaterialAlertDialogBuilder(this)
                     builder.setTitle("Saat Seçiniz")

                     builder.setItems(staticarray){
                             dialog, which ->  Log.e("saat",staticarray[which])
                         time_button.text=staticarray[which]

                     }
                     val dialog=builder.create()
                     dialog.show()



                 }else if (answertwo.text.toString()=="Bugün"){

                     val builder=MaterialAlertDialogBuilder(this)
                     builder.setTitle("Saat Seçiniz")
                     builder.setItems(staticarray){
                             dialog, which ->  Log.e("saat",staticarray[which])
                         time_button.text=staticarray[which]

                     }
                     val dialog=builder.create()
                     dialog.show()

                 }




             }
  */
        }

        makeorderbutton.setOnClickListener {
            val answerone = findViewById<Chip>(chipGroup.checkedChipId)
            val answertwo = findViewById<Chip>(chipGroup2.checkedChipId)
            if (answerone == null && answertwo == null) {

                val builder = MaterialAlertDialogBuilder(this)
                builder.setTitle("Mesaj")
                builder.setMessage("Alanlar Boş bırakılamaz")
                builder.background = resources.getDrawable(R.drawable.alert_shape, null)
                builder.setPositiveButton("Tamam", { dialog, which ->

                    dialog.dismiss()
                })
                val dialog = builder.create()
                dialog.show()


            } else {


                vm.completeBasket(
                    token,
                    restauranId,
                    answertwo.text.toString(),
                    time_button.text.toString()
                )

                vm.basketCompleteResponse.observe(this, Observer {

                    if (it.status) {

                        val intent = Intent(this, OrderDetailActivity::class.java)
                        intent.putExtra("order_id", it.data)
                        startActivity(intent)

                    }


                })


            }


        }


    }


    fun onclick(view: View) {

        onBackPressed()


    }
}
