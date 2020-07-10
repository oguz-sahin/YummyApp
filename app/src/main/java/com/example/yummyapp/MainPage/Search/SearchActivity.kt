package com.example.yummyapp.MainPage.Search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.yummyapp.Constans
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : AppCompatActivity() {
    private lateinit var adapter: TabAdapter
    private lateinit var vm: viewModel
    var token: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchWord = intent.getStringExtra(Constans.Search)
        Log.e("word searchactivity", searchWord)
        search_et.setText(searchWord)

        vm = ViewModelProvider(this).get(viewModel::class.java)
        val tokenPref = getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        token = tokenPref.getString(Constans.KEY_NAME, "")

        vm.CodeControl(1)

        if (savedInstanceState == null) {
            adapter = TabAdapter(supportFragmentManager)

            adapter.apply {
                addFragment(nearFragmet(searchWord), "Yakınımda")
                addFragment(AllFragment(searchWord), "Tümü")
                addFragment(PopularFragment(searchWord), "En Popüler")
                addFragment(LikedFragment(searchWord), "En Beğenilenler")
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

        search_et.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                Log.e("search", search_et.text.toString())
                return@OnEditorActionListener true
            }
            false
        })

        back.setOnClickListener {

            onBackPressed()

        }
    }


}
