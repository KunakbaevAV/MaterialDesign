package com.example.materialdesign

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.materialdesign.fragments.FragmentNotifications
import com.example.materialdesign.fragments.FragmentRecycler
import com.example.materialdesign.fragments.FragmentViewPager
import kotlinx.android.synthetic.main.activity_bottom_navigtion.*

class BottomNavigtionActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                openFragment(FragmentRecycler())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                openFragment(FragmentViewPager())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                openFragment(FragmentNotifications())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigtion)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        openFragment(FragmentRecycler())

    }
    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack("backStack")
                .commit()
    }

}
