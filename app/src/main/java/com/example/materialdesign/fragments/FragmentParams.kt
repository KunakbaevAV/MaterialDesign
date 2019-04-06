package com.example.materialdesign.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.materialdesign.R

class FragmentParams : Fragment() {
    lateinit var paramsText: TextView
    lateinit var iconType: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_params, container, false)
        paramsText = view.findViewById(R.id.params_text)
        iconType = view.findViewById(R.id.icon_type)
        return view
    }


}
