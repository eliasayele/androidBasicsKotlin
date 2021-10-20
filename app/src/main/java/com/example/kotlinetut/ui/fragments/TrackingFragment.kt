 package com.example.kotlinetut.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.kotlinetut.R
import com.example.kotlinetut.databinding.FragmentRunBinding
import com.example.kotlinetut.databinding.FragmentTrackingBinding
import com.example.kotlinetut.databinding.FragmentTrackingBindingImpl
import com.example.kotlinetut.ui.viewmodels.MainViewModel
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.AndroidEntryPoint

 @AndroidEntryPoint
 class TrackingFragment:Fragment(R.layout.fragment_tracking) {
    private val  viewModel: MainViewModel by viewModels()
     private  lateinit var binding: FragmentTrackingBinding
     private var map:GoogleMap? = null
     override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         binding = DataBindingUtil.inflate<FragmentTrackingBinding>(inflater,R.layout.fragment_tracking,container,false)
         return  binding.root
     }
     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         binding.mapView.onCreate(savedInstanceState)
          binding.mapView.getMapAsync{
              map = it
          }

     }

     override fun onResume() {
         super.onResume()
         binding.mapView?.onResume()
     }

     override fun onStart() {
         super.onStart()
         binding.mapView?.onStart()
     }

     override fun onStop() {
         super.onStop()
         binding.mapView?.onStop()
     }

     override fun onLowMemory() {
         super.onLowMemory()
         binding.mapView?.onLowMemory()
     }

     override fun onSaveInstanceState(outState: Bundle) {
         super.onSaveInstanceState(outState)
         binding.mapView?.onSaveInstanceState(outState)
     }

//     override fun onDestroy() {
//         super.onDestroy()
//         binding.mapView?.onDestroy()
//     }
}