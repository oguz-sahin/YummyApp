package com.example.yummyapp.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.yummyapp.MainPage.MainActivity
import com.example.yummyapp.R
import com.example.yummyapp.Register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        girisYap_button.setOnClickListener {

            val eposta = eposta_et.text.toString()
            val password = sifre_et.text.toString()

            apiClient.loginWithEmailandPassword(eposta, password)
                .enqueue(object : Callback<LoginModel> {
                    override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                        Log.e("on failure", t.message)
                    }

                    override fun onResponse(
                        call: Call<LoginModel>,
                        response: Response<LoginModel>
                    ) {

                        if (response.isSuccessful) {

                            if (response.body()!!.status) {
                                startActivity(Intent(this@Login, MainActivity::class.java))
                            } else {

                                Log.e("password ", "yanlış parola")
                            }

                        } else {

                            Log.e("tag", "message")
                        }
                    }

                })

        }


        kayitOl_button.setOnClickListener {
            startActivity(Intent(this@Login, RegisterActivity::class.java))

        }
    }
}
