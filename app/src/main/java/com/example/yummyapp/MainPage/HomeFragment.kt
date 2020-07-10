package com.example.yummyapp.MainPage

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Search.SearchActivity
import com.example.yummyapp.MainPage.UserApi.ApiClient
import com.example.yummyapp.MainPage.UserApi.ApiService
import com.example.yummyapp.MainPage.UserApi.UserModel
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(), LocationListener {
    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }
    lateinit var LocationManager: LocationManager
    var locationProvider = "gpsasd"
    var permissonControl = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val prefences =
            this.activity?.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = prefences?.getString(Constans.KEY_NAME, "")

        LocationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        Log.e("homefragmetoken", token)
        apiClient.getUserInformation("Bearer " + token).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.e("Fauilere", t.message)
            }

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                Log.e("user", response.body().toString())
                Log.e("status", response.body()?.status.toString())
                username_tv.text = response.body()?.data?.name
            }

        })

        search_button.setOnClickListener {
            val searchedWord = search_et.text.toString()



            permissonControl = ContextCompat.checkSelfPermission(
                this.activity!!,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )

            if (permissonControl != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                    this.activity!!,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    100
                )


            } else {

                val location = LocationManager.getLastKnownLocation(locationProvider)
                if (location != null) {

                    onLocationChanged(location)
                    val intent = Intent(this.activity, SearchActivity::class.java)
                    intent.putExtra(Constans.Search, searchedWord)
                    startActivity(intent)

                } else {


                    Log.e("tag", "Konum Alınamıyor")
                    val intent = Intent(this.activity, SearchActivity::class.java)
                    intent.putExtra(Constans.Search, searchedWord)
                    startActivity(intent)

                }

            }


        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == 100) {
            permissonControl = ContextCompat.checkSelfPermission(
                this.activity!!,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )

            Log.e("tag", grantResults.toString())

            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                val location = LocationManager.getLastKnownLocation(locationProvider)
                if (location != null) {

                    onLocationChanged(location)

                } else {

                    Log.e("tag", "Konum Alınamıyor")

                }
                //  startActivity(Intent(this.activity, SearchActivity::class.java))

            } else {

                Toast.makeText(this.activity, "izin onaylanmadı", Toast.LENGTH_LONG).show()

            }
        }
    }

    override fun onLocationChanged(location: Location?) {
        val enlem = location?.latitude
        val boylam = location?.longitude

        Log.e("enlem boylam", "$enlem $boylam")

    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }

    override fun onProviderEnabled(provider: String?) {

    }

    override fun onProviderDisabled(provider: String?) {

    }

}
