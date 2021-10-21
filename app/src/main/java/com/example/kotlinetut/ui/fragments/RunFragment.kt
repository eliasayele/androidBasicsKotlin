package com.example.kotlinetut.ui.fragments

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.kotlinetut.R
import com.example.kotlinetut.databinding.FragmentRunBinding
import com.example.kotlinetut.other.Constants.REQUEST_CODE_LOCATION_PERMISSION
import com.example.kotlinetut.other.TrackingUtility
import com.example.kotlinetut.ui.viewmodels.MainViewModel
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunFragment:Fragment(R.layout.fragment_run) ,EasyPermissions.PermissionCallbacks{

    private val  viewModel:MainViewModel by viewModels()
    private lateinit var binding: FragmentRunBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requestPermission()
     binding = DataBindingUtil.inflate<FragmentRunBinding>(inflater,R.layout.fragment_run,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requestPermission()
        binding.fab.setOnClickListener{view:View ->
            view.findNavController().navigate(R.id.action_runFragment_to_trackingFragment)
        }
    }

    private fun requestPermission(){
        if(TrackingUtility.hasLocationPermissions(requireContext())){
            return
        }
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
            EasyPermissions.requestPermissions(
                this,
                "You need to accept location permission to use this",
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
//            EasyPermissions.requestPermissions(
//                this,
//                "You need to accept location permission to use this",
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            )
//            EasyPermissions.requestPermissions(
//                this,
//                "You need to accept location permission to use this",
//
//                Manifest.permission.ACCESS_FINE_LOCATION
//            )
        } else{
            EasyPermissions.requestPermissions(
                this,
                "You need to accept location permission to use this",
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
//    }
    val permReqLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permissions ->
        val granted  =  permissions.entries.all {
            it.value == true
        }
        if (granted) {
            Toast.makeText(context,"permission granted",Toast.LENGTH_LONG).show()
//            EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
        } else {
            // Failed pass
            requestPermission()

        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            SettingsDialog.Builder(requireActivity()).build().show()
        } else {
            requestPermission()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        TODO("Not yet implemented")
    }

}