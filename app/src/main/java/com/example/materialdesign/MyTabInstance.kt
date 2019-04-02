package com.example.materialdesign

import android.os.Bundle

fun newInstance(text: String, color: Int): TabFragment {
    val args = Bundle()
    args.putString(TEXT, text)
    args.putInt(COLOR, color)
    val fragment = TabFragment()
    fragment.arguments = args
    return fragment
}