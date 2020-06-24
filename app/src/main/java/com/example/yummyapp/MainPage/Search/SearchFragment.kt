package com.example.yummyapp.MainPage.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.yummyapp.MainPage.Model.viewModel
import com.example.yummyapp.R


class SearchFragment : Fragment() {
    private lateinit var vm: viewModel
    private lateinit var adapter: TabAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProviders.of(requireActivity()).get(viewModel::class.java)


    }

}
