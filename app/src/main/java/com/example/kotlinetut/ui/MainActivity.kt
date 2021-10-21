package com.example.kotlinetut.ui

//import com.example.kotlinetut.R

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.setupWithNavController
import com.example.kotlinetut.R
//import com.example.kotlinetut.databinding.ActivityMainBinding
//import com.example.kotlinetut.databinding.ItemRunBinding
import com.example.kotlinetut.db.RunDAO
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinetut.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
     val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolbar)
        val navController: NavController =
            Navigation.findNavController(this, R.id.navHostFragment)

        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _,destination,_ ->
            when(destination.id){
                R.id.settingsFragment , R.id.statisticFragment, R.id.runFragment  ->
                    binding.bottomNavigationView.visibility = View.VISIBLE

                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }

        ///clients offers inclination


    }



}