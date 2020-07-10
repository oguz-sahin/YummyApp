package com.example.yummyapp.MainPage.Restaurant

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.Photo
import com.example.yummyapp.MainPage.Model.photosModel
import com.example.yummyapp.MainPage.Restaurant.Mvvm.restaurantViewModel
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.OnSwipeTouchListener
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_restaurant_photos.*
import kotlinx.android.synthetic.main.item_food.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantPhotosActivity : AppCompatActivity() {


     private val apiClient: ApiService by lazy { ApiClient.getApiClient() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_photos)
        lateinit var vm:restaurantViewModel
        lateinit var gelenresponse: photosModel

        var url=ArrayList<Photo>()
        val imageList = ArrayList<SlideModel>()
        val tokenPref =getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")


        //RestaurantId
        val prefences = getSharedPreferences(Constans.RESTAURANT_FILE, Context.MODE_PRIVATE)
        val restaurantId = prefences.getString(Constans.RestaurantID,"0")


        vm=ViewModelProvider(this).get(restaurantViewModel::class.java)
      vm.getRestorantsPhotosWithToken(token!!,restaurantId!!)
     vm.restaurantPhotos.observe(this, Observer {
          Log.e("as",it.data.toString())

        })


        //"https://yummy.wookweb.com/assets/img/restoran/"
       // imageList.add(SlideModel("https://www.turizmajansi.com/images/haber/cafe-ve-restoran-dekorasy_8cae.jpg"))


       /* for (i in 0 until it.data.size){

            imageList.add(SlideModel("https://yummy.wookweb.com/assets/img/restoran/"+it.data[i].image))

        }*/


         imageList.add(SlideModel("https://yummy.wookweb.com/assets/img/restoran/5ef34d1860c32.jpg"))
        imageList.add(SlideModel("https://yummy.wookweb.com/assets/img/restoran/5ef34d1861227.jpg"))
        /*  imageList.add(SlideModel("https://www.turizmajansi.com/images/haber/cafe-ve-restoran-dekorasy_8cae.jpg"))
       imageList.add(SlideModel("https://www.turizmajansi.com/images/haber/cafe-ve-restoran-dekorasy_8cae.jpg"))*/

         var imageSlider=findViewById<ImageSlider>(R.id.image_slider)
         imageSlider.setImageList(imageList)


     /*   imageSlider.setOnTouchListener(object :OnSwipeTouchListener(this){


            override fun onSwipeBottom() {
                finish()
            }


        })
*/
       imageSlider.setOnClickListener{

            finish()

        }


    }
}
