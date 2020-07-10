package com.example.yummyapp.MainPage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyapp.Constans
import com.example.yummyapp.R
import com.example.yummyapp.Sepetim.BasketAdapter
import com.example.yummyapp.Sepetim.BasketItemClick
import com.example.yummyapp.Sepetim.BasketViewModel
import com.example.yummyapp.Sepetim.OrderInformationActivity
import com.example.yummyapp.SwipeToDeleteCallback
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_adisyon.*

/**
 * A simple [Fragment] subclass.
 */
class AdisyonFragment : Fragment(), BasketItemClick {

    lateinit var vm: BasketViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adisyon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tokenPref =
            activity!!.getSharedPreferences(Constans.PREFS_FILENAME, Context.MODE_PRIVATE)
        val token = tokenPref.getString(Constans.KEY_NAME, "")
        Log.e("tag", token)

        if (token == "guest") {

            val builder = MaterialAlertDialogBuilder(context)
                .setBackground(context!!.getDrawable(R.drawable.alert_shape))
                .setTitle("Uyarı")
                .setMessage("Kayıt Olmadan Sepet Oluşturamazsınız")
                .setIcon(R.drawable.ic_delete)
                .setPositiveButton("Tamam", { dialog, which ->

                    dialog.dismiss()


                })

            val dialog = builder.create()
            dialog.show()

        } else {

            vm = ViewModelProvider(this).get(BasketViewModel::class.java)
            vm.getBasket(token!!)
            vm.basket.observe(this.activity!!, Observer {
                if (it.status == false) {

                    Toast.makeText(activity, "Sepetiniz boş", Toast.LENGTH_LONG).show()
                } else {
                    recyclerview.layoutManager = LinearLayoutManager(this.activity)
                    recyclerview.adapter = BasketAdapter(it.data, this)
                }

            })

            val deleteSwipeHandler = object : SwipeToDeleteCallback(activity!!) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                    val adapter = recyclerview.adapter as BasketAdapter //cast istiyor
                    adapter.notifyDeleteItem(
                        activity!!,
                        activity!!,
                        viewHolder.adapterPosition, token
                    )

                }


            }
            val deleteItemTouchHelper = ItemTouchHelper(deleteSwipeHandler)
            deleteItemTouchHelper.attachToRecyclerView(recyclerview)

        }


    }


    /*  val editSwipeHandler = object : SwipeToEditCallback(activity!!) {
          override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

              val adapter = recyclerview.adapter as BasketAdapter //cast istiyor
              adapter.notifyEditItem(
                  activity!!,
                  activity!!,
                  viewHolder.adapterPosition
              )

          }


      }
      val editItemTouchHelper = ItemTouchHelper(editSwipeHandler)
      editItemTouchHelper.attachToRecyclerView(recyclerview)*/


    override fun itemClick(id: String) {

        val intent = Intent(activity, OrderInformationActivity::class.java)
        intent.putExtra(Constans.sepetId, id)
        startActivity(intent)
    }

}
