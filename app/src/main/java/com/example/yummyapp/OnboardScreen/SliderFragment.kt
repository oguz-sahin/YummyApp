package com.example.yummyapp.OnboardScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.fragment_slider.*

/**
 * A simple [Fragment] subclass.
 */
class SliderFragment : Fragment() {

    var pageTitle: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragment_title.text = pageTitle
    }

    fun setTitle(title: String) {
        pageTitle = title
    }

}
