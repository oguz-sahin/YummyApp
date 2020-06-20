package com.example.yummyapp.OnboardScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_slider.*


class SliderFragment : Fragment() {

    var pageTitle: String = ""
    var pageImage: Int = 0
    var pageDescription: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        slide_baslik_tv.text = pageTitle
        slide_aciklama_tv.text = pageDescription
        slide_iv.setImageResource(pageImage)
    }

    fun setFragment(title: String, image: Int, description: String) {
        pageTitle = title
        pageImage = image
        pageDescription = description

    }

}
