package com.example.yummyapp.Login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.MainActivity
import com.example.yummyapp.R
import com.example.yummyapp.Register.RegisterActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    private val apiClient: ApiService by lazy { ApiClient.getApiClient() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefences = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val editor = prefences.edit()


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

                                LoginingProgressDialog()
                                editor.putString(Constans.KEY_NAME, response.body()?.data?.token)
                                editor.apply()
                                Log.e("response", response.body().toString())
                                startActivity(Intent(this@Login, MainActivity::class.java))
                                finish()
                            } else {
                                wrongPasswordDialog()

                            }

                        } else {

                            Log.e("hata", "response başarılı fakat bir şeyler ters gidiyor.")
                        }
                    }

                })

        }


        kayitOl_button.setOnClickListener {
            startActivity(Intent(this@Login, RegisterActivity::class.java))

        }

        guestLogin_button.setOnClickListener {
            editor.putString(Constans.KEY_NAME, "guest")
            editor.apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }

    fun LoginingProgressDialog() {

        val builder = MaterialAlertDialogBuilder(this)
        val dialogView = layoutInflater.inflate(R.layout.progress_dialog, null)
        val message = dialogView.findViewById<TextView>(R.id.message)
        message.text = "Giriş Yapılıyor..."
        builder.setView(dialogView)
        builder.setCancelable(false)
        val dialog = builder.create()
        dialog.show()


    }


    fun wrongPasswordDialog() {

        val builder = MaterialAlertDialogBuilder(this)
        builder.setTitle("Hatalı Giriş")
        builder.setMessage("Hatalı E-posta veya şifre girdiniz")
        builder.background = resources.getDrawable(R.drawable.alert_shape, null)
        builder.setPositiveButton("Tamam", { dialog, which ->

            dialog.dismiss()
        })
        val dialog = builder.create()
        dialog.show()


    }
}
