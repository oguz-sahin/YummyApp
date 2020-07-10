package com.example.yummyapp.Sepetim

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.yummyapp.R
import com.google.android.material.button.MaterialButton

class TimePicker : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = java.util.Calendar.getInstance()
        val hour = c.get(java.util.Calendar.HOUR_OF_DAY)
        val minute = c.get(java.util.Calendar.MINUTE)


        return TimePickerDialog(activity, TimePicker.AUTOFILL_TYPE_LIST, this, hour, minute, true)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

        val button = activity?.findViewById<MaterialButton>(R.id.time_button)
        button?.text = "$hourOfDay : $minute"


    }
}