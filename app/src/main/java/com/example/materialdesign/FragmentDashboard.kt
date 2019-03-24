package com.example.materialdesign


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class FragmentDashboard : Fragment() {
//    lateinit var myAndroid: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        myAndroid = view.findViewById(R.id.android)
//        myAndroid.setOnClickListener { _ -> changeFragment(fragmentManager, FragmentHome(), myAndroid) }
        return view
    }


}
