package com.example.yummyapp.Register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.yummyapp.Constans
import com.example.yummyapp.Login.Login
import com.example.yummyapp.MainPage.MainActivity
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private val apiClient: RegisterApiService by lazy { RegisterApiClient.getApiClient() }
    var status: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val prefences = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val editor = prefences.edit()



        kayitOl_button.setOnClickListener {

            val name = name_et.text.toString()
            val email = eposta_et.text.toString()
            val password = sifre_et.text.toString()
            val phone = phone_et.text.toString()

            apiClient.Register(email, password, name, phone)
                .enqueue(object : Callback<RegisterModel> {
                    override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                        Log.e("fauiler", t.message)
                    }

                    override fun onResponse(
                        call: Call<RegisterModel>,
                        response: Response<RegisterModel>
                    ) {

                        if (response.isSuccessful) {
                            val data = response.body()?.data
                            status = response.body()!!.status
                            Log.e("data", data.toString())
                            Log.e("message", response.body()?.message)

                            if (status) {
                                editor.putString(Constans.KEY_NAME, data?.token)
                                editor.apply()
                                startActivity(
                                    Intent(
                                        this@RegisterActivity,
                                        MainActivity::class.java
                                    )
                                )

                            } else {

                                Log.e("status", status.toString())

                            }


                        } else {

                            Log.e("succsesfuleror", "succesfull response eror")


                        }


                    }


                })


        }

        girisYap()


    }

    fun girisYap() {

        girisYap_button.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, Login::class.java))
        }


    }
}

