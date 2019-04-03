package com.example.materialdesign.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.materialdesign.R
import com.example.materialdesign.utils.DrawableUtils

class FragmentAnimated : Fragment() {
    lateinit var myAndroid: ImageView
    lateinit var drawableUtils: DrawableUtils
    var isStarted = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_animation, container, false)
        myAndroid = view.findViewById(R.id.my_android)
        drawableUtils = DrawableUtils(myAndroid)
        myAndroid.setOnClickListener { startAnimation() }
        return view
    }

    private fun startAnimation() {
        if (isStarted) {
            myAndroid.setImageResource(R.drawable.ic_android_green_600_36dp)
            isStarted = false
        } else {
            myAndroid.setImageResource(R.drawable.android_animated)
            drawableUtils.startAnimationDrawable()
            isStarted = true
        }
    }
}
