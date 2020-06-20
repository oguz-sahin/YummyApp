package com.example.yummyapp.MainPage.Search

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.MainPage.Service.ApiClient
import com.example.yummyapp.MainPage.Service.ApiService
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    private lateinit var adapter: TabAdapter
    lateinit var viewModel: viewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        val apiClient: ApiService = ApiClient.getApiClient()
        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")

        val codePref = getSharedPreferences(Constans.PREFS_ClickCode, Context.MODE_PRIVATE)
        val editor = codePref.edit()
        editor.putInt(Constans.Code_KEY_NAME, 1)
        editor.commit()

        viewModel = ViewModelProviders.of(this)
            .get(com.example.yummyapp.MainPage.Model.viewModel::class.java)
        viewModel.getRestaurantsWithToken(token!!)

        adapter = TabAdapter(supportFragmentManager)

        adapter.apply {
            addFragment(nearFragmet(), "Yakınımda")
            addFragment(AllFragment(), "Tümü")
            addFragment(PopularFragment(), "En Popüler")
            addFragment(LikedFragment(), "En Beğenilenler")
        }
        view_pager.adapter = adapter
        tabLayout.setupWithViewPager(view_pager)


        grid_icon.setOnClickListener {
            editor.putInt(Constans.Code_KEY_NAME, 1)
            editor.commit()
        }
        list_icon.setOnClickListener {
            editor.putInt(Constans.Code_KEY_NAME, 2)
            editor.commit()


        }

    }
}
