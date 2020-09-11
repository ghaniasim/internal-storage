package com.example.internalstorage

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_first.*



class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save.setOnClickListener {
            activity!!.applicationContext.openFileOutput(FILENAME, Context.MODE_APPEND).use {
                it?.write("${editText.text}\n".toByteArray())
            }
            editText.text.clear()
            Toast.makeText(activity?.baseContext, "File saved", Toast.LENGTH_SHORT).show()
        }
    }
}