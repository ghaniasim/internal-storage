package com.example.internalstorage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*
import java.io.File

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isFilePresent(FILENAME)) {
            textView.text =
                activity!!.applicationContext.openFileInput(FILENAME)?.bufferedReader().use {
                it?.readText() ?: "Can't read file"
            }
        } else {
            textView.text = "File does not exist"
        }
    }

    private fun isFilePresent(fileName: String): Boolean {
        val path = context!!.filesDir.absolutePath + "/" + fileName
        val file = File(path)
        return file.exists()
    }
}