package com.example.materialdesign

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.materialdesign.pageTransformations.DepthTransformer
import com.example.materialdesign.pageTransformations.MyPageTransformer

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
        adapter.addFragment(newInstance("Second", Color.CYAN))
        adapter.addFragment(newInstance("Third", Color.GREEN))
        viewPager.adapter = adapter
        viewPager.setPageTransformer(false, DepthTransformer())
    }
}