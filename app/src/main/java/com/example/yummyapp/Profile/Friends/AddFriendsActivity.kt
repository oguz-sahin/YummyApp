package com.example.yummyapp.Profile.Friends

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummyapp.Profile.Friends.Model.User
import com.example.yummyapp.R
import kotlinx.android.synthetic.main.activity_add_friends.*

class AddFriendsActivity : AppCompatActivity(), ItemCheck {
    lateinit var adapter: AddFriendAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friends)


        var array = ArrayList<User>()
        array.add(User("1", "a@m.com", "hasan"))
        array.add(User("2", "b@m.com", "özgür"))
        array.add(User("3", "c@m.com", "onur"))

        adapter = AddFriendAdapter(array, this)

        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)


        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.e("search", s.toString())
                adapter.filter.filter(s.toString())
            }


        })


    }

    override fun ItemCheck(users: ArrayList<User>) {
        ekle_button.setOnClickListener {

            Log.e("friends", users.toString())

        }
    }
}
