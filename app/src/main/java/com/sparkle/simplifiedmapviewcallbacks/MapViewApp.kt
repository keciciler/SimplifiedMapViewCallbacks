package com.sparkle.simplifiedmapviewcallbacks

import androidx.multidex.MultiDexApplication

class MapViewApp : MultiDexApplication() {

    companion object {

        var INSTANCE: MapViewApp? = null

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

}