package com.example.yummyapp.MainPage.Restaurant

import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_make_comment.*

class MakeCommentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_comment)


        priceSeekbar()
        serviceSeekbar()
        locationSeekbar()
        tasteSeekbar()


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
            }


        })
        back.setOnClickListener {

            startActivity(Intent(this, restaurantActivity::class.java))


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
            }


        })

    }
}
