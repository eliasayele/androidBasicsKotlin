package com.example.kotlinetut.ui

//import com.example.kotlinetut.R

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.setupWithNavController
import com.example.kotlinetut.R
import com.example.kotlinetut.databinding.ActivityMainBinding
import com.example.kotlinetut.databinding.ItemRunBinding
import com.example.kotlinetut.db.RunDAO
import dagger.hilt.android.AndroidEntryPoint
import hilt_aggregated_deps._com_example_kotlinetut_ui_fragments_RunFragment_GeneratedInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
     val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
//
      //binding.bottomNavigationView.setupWithNavController(R.id.navHostFragment.findNavController())
//

    }


}