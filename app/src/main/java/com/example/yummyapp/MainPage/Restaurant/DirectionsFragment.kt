package com.example.yummyapp.MainPage.Restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yummyapp.Constans
import com.example.yummyapp.R

/**
 * A simple [Fragment] subclass.
 */
class DirectionsFragment : Fragment() {
    companion object {

        fun newInstance(restaurantId: String): DirectionsFragment {
            val args = Bundle()
            args.putString(Constans.RestaurantID, restaurantId)
            val fragment = DirectionsFragment()
            fragment.arguments = args
            return fragment
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_directions, container, false)
    }

}
