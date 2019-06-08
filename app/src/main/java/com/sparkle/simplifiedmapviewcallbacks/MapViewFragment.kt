package com.sparkle.simplifiedmapviewcallbacks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.OnMapReadyCallback
import com.google.android.libraries.maps.model.LatLng
import com.sparkle.simplifiedmapviewcallbacks.databinding.FragmentMapviewBinding
import kotlinx.android.synthetic.main.fragment_mapview.*

const val ISTANBUL_LATITUDE = 41.078603
const val ISTANBUL_LONGITUDE = 29.022461
const val DEFAULT_CAMERA_ZOOM = 10F
const val MIN_CAMERA_ZOOM = 6F
const val MAX_CAMERA_ZOOM = 15F

class MapViewFragment : Fragment(),
    MapViewProvider,
    OnMapReadyCallback {

    private lateinit var binding: FragmentMapviewBinding
    private var googleMap: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (!this::binding.isInitialized) {
            binding = (DataBindingUtil.inflate(inflater, R.layout.fragment_mapview, container, false)
                    as FragmentMapviewBinding).apply {
                lifecycleOwner = this@MapViewFragment
            }
        }
        return binding.root
    }

    override fun getMapView(): MapView? {
        return mapViewFragmentMapView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapViewFragmentMapView.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMap = googleMap
        googleMap?.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(ISTANBUL_LATITUDE, ISTANBUL_LONGITUDE),
                DEFAULT_CAMERA_ZOOM
            )
        )
        googleMap?.setMinZoomPreference(MIN_CAMERA_ZOOM)
        googleMap?.setMaxZoomPreference(MAX_CAMERA_ZOOM)
    }


}
