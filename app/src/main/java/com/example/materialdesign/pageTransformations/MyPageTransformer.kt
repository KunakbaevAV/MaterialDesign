package com.example.materialdesign.pageTransformations

import android.view.View
import androidx.viewpager.widget.ViewPager

class MyPageTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.cameraDistance = page.width * 20f
        page.rotationX = 90f * position
    }
}