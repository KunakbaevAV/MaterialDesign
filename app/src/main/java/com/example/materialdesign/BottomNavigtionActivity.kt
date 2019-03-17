package com.example.materialdesign

import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bottom_navigtion.*

class BottomNavigtionActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentHome())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentDashboard())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentNotifications())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigtion)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
