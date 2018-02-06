package com.dev_juyoung.udemykotlinsample.view.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.dev_juyoung.udemykotlinsample.R
import com.dev_juyoung.udemykotlinsample.util.replace
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment: HomeFragment by lazy {
        HomeFragment().apply {
            arguments = Bundle().apply {
                putInt(HomeFragment.KEY_TITLE, R.string.title_home)
            }
        }
    }
    private val cameraFragment: CameraFragment by lazy {
        CameraFragment().apply {
            arguments = Bundle().apply {
                putInt(CameraFragment.KEY_TITLE, R.string.title_camera)
            }
        }
    }
    private val moreFragment: MoreFragment by lazy {
        MoreFragment().apply {
            arguments = Bundle().apply {
                putInt(MoreFragment.KEY_TITLE, R.string.title_more)
            }
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replace(R.id.contentFrame, homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_camera -> {
                replace(R.id.contentFrame, cameraFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more -> {
                replace(R.id.contentFrame, moreFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replace(R.id.contentFrame, homeFragment)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
