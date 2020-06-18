package com.example.yummyapp.OnboardScreen

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.yummyapp.Login.Login
import com.example.yummyapp.MainPage.MainActivity
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_intro_screen.*

class introScreen : AppCompatActivity() {

    val fragment1 = SliderFragment()
    val fragment2 = SliderFragment()
    val fragment3 = SliderFragment()
    lateinit var adapter: myPagerAdapter
    lateinit var activity: Activity


    lateinit var preference: SharedPreferences
    val pref_show_intro = "Intro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screen)

        activity = this
        preference = getSharedPreferences("IntroSlider", Context.MODE_PRIVATE)

        if (!preference.getBoolean(pref_show_intro, true)) {
            startActivity(Intent(activity, Login::class.java))
            finish()
        }

        fragment1.setFragment(
            resources.getString(R.string.yakınındakilerikeşfet),
            R.drawable.slide1,
            resources.getString(R.string.yakındakikesfettext)
        )
        fragment2.setFragment(
            resources.getString(R.string.lezzetliMenüseç),
            R.drawable.slide2,
            resources.getString(R.string.lezzetlimenütext)
        )
        fragment3.setFragment(
            resources.getString(R.string.rezervasyonYap),
            R.drawable.slide3,
            resources.getString(R.string.rezervasyontext)
        )


        adapter = myPagerAdapter(supportFragmentManager)
        adapter.list.add(fragment1)
        adapter.list.add(fragment2)
        adapter.list.add(fragment3)

        view_pager.adapter = adapter
        btn_next.setOnClickListener {
            view_pager.currentItem++
        }

        btn_skip.setOnClickListener { goToDashboard() }

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == adapter.list.size - 1) {
                    //lastPage
                    btn_next.text = "DONE"
                    btn_next.setOnClickListener {
                        goToDashboard()
                    }
                } else {
                    //has next
                    btn_next.text = "NEXT"
                    btn_next.setOnClickListener {
                        view_pager.currentItem++
                    }
                }

                when (view_pager.currentItem) {
                    0 -> {
                        indicator1.setTextColor(resources.getColor(R.color.ColorMain))
                        indicator2.setTextColor(Color.GRAY)
                        indicator3.setTextColor(Color.GRAY)
                    }
                    1 -> {
                        indicator1.setTextColor(Color.GRAY)
                        indicator2.setTextColor(resources.getColor(R.color.ColorMain))
                        indicator3.setTextColor(Color.GRAY)
                    }
                    2 -> {
                        indicator1.setTextColor(Color.GRAY)
                        indicator2.setTextColor(Color.GRAY)
                        indicator3.setTextColor(resources.getColor(R.color.ColorMain))
                    }
                }

            }

        })

    }

    fun goToDashboard() {
        startActivity(Intent(activity, MainActivity::class.java))
        finish()
        val editor = preference.edit()
        editor.putBoolean(pref_show_intro, false)
        editor.apply()
    }

    class myPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        val list: MutableList<Fragment> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return list[position]
        }

        override fun getCount(): Int {
            return list.size
        }

    }
}


