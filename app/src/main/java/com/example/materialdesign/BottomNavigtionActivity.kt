package com.example.materialdesign

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_bottom_navigtion.*

class BottomNavigtionActivity : AppCompatActivity() {
//    lateinit var messageBadge: TextView
//    lateinit var messageCount: SharedPreferences

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                openFragment(FragmentHome())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                openFragment(FragmentDashboard())
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
//        messageBadge = findViewById(R.id.message)
//        updateMessageBadge()
        openFragment(FragmentHome())

    }
    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }

}
