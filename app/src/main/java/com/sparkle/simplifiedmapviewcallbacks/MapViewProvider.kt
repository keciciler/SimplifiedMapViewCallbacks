package com.sparkle.simplifiedmapviewcallbacks

import com.google.android.libraries.maps.MapView

interface MapViewProvider {

    fun getMapView(): MapView?

}