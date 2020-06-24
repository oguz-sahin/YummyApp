package com.example.yummyapp.MainPage.Search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.yummyapp.MainPage.MainActivity
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    private lateinit var adapter: TabAdapter
    private lateinit var vm: viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        vm = ViewModelProviders.of(this).get(viewModel::class.java)

        vm.CodeControl(1)

        if (savedInstanceState == null) {
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
                vm.CodeControl(1)
                Log.e("tag", "1")
            }
            list_icon.setOnClickListener {
                Log.e("tag", "2")
                vm.CodeControl(2)
            }

        }

        back.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))

        }


        //  supportFragmentManager.beginTransaction().add(R.id.coordinatorLAyout,SearchFragment()).commit()
    }
}
