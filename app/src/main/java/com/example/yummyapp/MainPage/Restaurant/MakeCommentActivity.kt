package com.example.yummyapp.MainPage.Restaurant

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Restaurant.Mvvm.MakeCommentViewModel
import com.example.yummyapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_make_comment.*

class MakeCommentActivity : AppCompatActivity() {


    private lateinit var vm: MakeCommentViewModel

    var food_quality: Int? = 0
    var service: Int? = 0
    var location: Int? = 0
    var price: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_comment)

        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")
        val prefences = getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val restaurantId = prefences?.getString(Constans.RestaurantID, "0")

        Log.e("token", token)
        Log.e("resId", restaurantId)


        vm = ViewModelProvider(this).get(MakeCommentViewModel::class.java)

        priceSeekbar()
        serviceSeekbar()
        locationSeekbar()
        tasteSeekbar()



        send_button.setOnClickListener {


            val comment = comment_et.text.toString()
            if (comment.trim().isEmpty()) comment_et.error = "Yorum Alanı Boş Bırakılamaz"
            else {


                vm.MakeComment(
                    token!!,
                    restaurantId!!,
                    "Boş",
                    food_quality!!,
                    service!!,
                    location!!,
                    price!!,
                    comment
                )
                vm.status.observe(this, Observer {

                    Log.e("status", it.toString())
                    if (it) {
                        comment_et.text?.clear()
                        price_seekBar.progress = 0
                        location_seekbar.progress = 0
                        taste_seekBar.progress = 0
                        service_seekbar.progress = 0
                        val builder = MaterialAlertDialogBuilder(this)
                        builder.setTitle("Mesaj")
                        builder.setMessage("Yorumunuz yönetici onayladıktan sonra yayınlanacaktır")
                        builder.background = resources.getDrawable(R.drawable.alert_shape, null)
                        builder.setPositiveButton("Tamam", { dialog, which ->

                            dialog.dismiss()
                        })
                        val dialog = builder.create()
                        dialog.show()

                    }


                })


            }


        }



    }


    fun priceSeekbar() {


        price_seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                price_tv.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                price_tv.text = seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                price_tv.text = seekBar?.progress.toString()
                price = seekBar?.progress
                Log.e("price", price.toString())
            }


        })


    }

    fun serviceSeekbar() {

        service_seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                service_tv.text = progress.toString()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                service_tv.text = seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                service_tv.text = seekBar?.progress.toString()
                service = seekBar?.progress
                Log.e("service", service.toString())

            }


        })
        back.setOnClickListener {

            onBackPressed()

        }


    }


    fun locationSeekbar() {

        location_seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                location_value_tv.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                location_value_tv.text = seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                location_value_tv.text = seekBar?.progress.toString()
                location = seekBar?.progress
                Log.e("location", location.toString())
            }


        })

    }


    fun tasteSeekbar() {

        taste_seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                taste_tv.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                taste_tv.text = seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                taste_tv.text = seekBar?.progress.toString()
                food_quality = seekBar?.progress
                Log.e("food_quality", food_quality.toString())
            }


        })

    }
}
