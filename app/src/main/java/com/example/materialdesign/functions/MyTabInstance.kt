package com.example.materialdesign.functions

import android.os.Bundle
import com.example.materialdesign.COLOR
import com.example.materialdesign.TEXT
import com.example.materialdesign.fragments.TabFragment

fun newInstance(text: String, color: Int): TabFragment {
    val args = Bundle()
    args.putString(TEXT, text)
    args.putInt(COLOR, color)
    val fragment = TabFragment()
    fragment.arguments = args
    return fragment
}