package com.example.materialdesign.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.materialdesign.R
import com.example.materialdesign.utils.view_pager.MyPagerAdapter
import com.example.materialdesign.functions.newInstance
import com.example.materialdesign.utils.pageTransformations.DepthTransformer

class FragmentViewPager : Fragment() {
    lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        viewPager = view.findViewById(R.id.view_pager)
        initAdapter(viewPager)
        return view
    }

    private fun initAdapter(viewPager: ViewPager) {
        val adapter = MyPagerAdapter(childFragmentManager)
        adapter.addFragment(newInstance("First", Color.BLUE))
        adapter.addFragment(FragmentAnimated())
        adapter.addFragment(FragmentRecyclerChosen())
        adapter.addFragment(newInstance("Third", Color.GREEN))
        viewPager.adapter = adapter
        viewPager.setPageTransformer(false, DepthTransformer())
    }
}