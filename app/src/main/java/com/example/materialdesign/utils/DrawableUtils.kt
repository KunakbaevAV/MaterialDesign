package com.example.materialdesign.utils

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import android.widget.ImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class DrawableUtils(var imageView: ImageView) {
    fun startAnimationDrawable() {
        val drawable = imageView.drawable
        if (drawable is AnimatedVectorDrawable) {
            drawable.start()
        } else if (drawable is AnimatedVectorDrawableCompat) {
            drawable.start()
        }
    }

    fun stopAnimationDrawable() {
        val drawable = imageView.drawable
        if (drawable is AnimatedVectorDrawable) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                drawable.reset()
            } else {
                drawable.stop()
            }
        } else if (drawable is AnimatedVectorDrawableCompat) {
            drawable.stop()
        }
    }
}