package com.sparkle.simplifiedmapviewcallbacks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.registerFragmentLifecycleCallbacks(
            MapViewFragmentStateLifecycleCallback, true
        )
        setContentView(R.layout.activity_main)
    }
}
