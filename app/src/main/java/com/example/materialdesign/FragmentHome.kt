package com.example.materialdesign


import android.os.Bundle
import android.transition.ArcMotion
import android.transition.ChangeBounds
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar

class FragmentHome : Fragment() {
    lateinit var myAndroid: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        myAndroid = view.findViewById(R.id.android)
        myAndroid.setOnClickListener { v -> changeFragment(fragmentManager, FragmentDashboard(), myAndroid) }
        return view
    }

}
