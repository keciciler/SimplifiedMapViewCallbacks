package com.sparkle.simplifiedmapviewcallbacks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object MapViewFragmentStateLifecycleCallback : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
        if (f is MapViewProvider) {
            f.getMapView()?.onResume()
        }
    }

    //Due to databinding library view inflation is done onCreateView callback of activity.
    override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
        if (f is MapViewProvider) {
            f.getMapView()?.onCreate(savedInstanceState)
        }
    }

    override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
        if (f is MapViewProvider) {
            f.getMapView()?.onDestroy()
        }
    }

    //Due to databinding library view inflation is done onCreateView callback of activity.
    override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
        if (f is MapViewProvider && f.getMapView() != null && f.getMapView()!!.isLaidOut) {
            f.getMapView()!!.onStart()
        }
    }

    override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
        if (f is MapViewProvider) {
            f.getMapView()?.onStop()
        }
    }

    override fun onFragmentSaveInstanceState(fm: FragmentManager, f: Fragment, outState: Bundle) {
        if (f is MapViewProvider) {
            f.getMapView()?.onSaveInstanceState(outState)
        }
    }

    override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
        if (f is MapViewProvider) {
            f.getMapView()?.onPause()
        }
    }

}