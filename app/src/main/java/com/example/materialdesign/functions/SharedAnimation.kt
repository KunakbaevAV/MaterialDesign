package com.example.materialdesign.functions

import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.materialdesign.R

fun changeFragment(fragmentManager: FragmentManager?, nextFragment: Fragment, image: ImageView) {
    val changeBounds = ChangeBounds()
    changeBounds.pathMotion = ArcMotion()
    changeBounds.duration = 500
    changeBounds.interpolator = OvershootInterpolator(1.5f)
    nextFragment.sharedElementEnterTransition = changeBounds

    fragmentManager!!.beginTransaction()
            .replace(R.id.container, nextFragment)
            .addSharedElement(image, image.transitionName)
            .commit()
}