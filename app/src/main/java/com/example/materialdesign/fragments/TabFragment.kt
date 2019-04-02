package com.example.materialdesign.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.materialdesign.COLOR
import com.example.materialdesign.R
import com.example.materialdesign.TEXT

class TabFragment : Fragment() {
    var text: String? = "empty"
    var color: Int = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        text = arguments!!.getString(TEXT)
        color = arguments!!.getInt(COLOR)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tab, container, false)
        view.findViewById<TextView>(R.id.tab_text).text = text
        view.setBackgroundColor(color)
        return view
    }
}