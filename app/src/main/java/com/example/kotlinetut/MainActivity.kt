package com.example.kotlinetut


import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kotlinetut.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)

         val firstFragment = FirstFragment()
         val secondFragment  = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(binding.mainFirstFragment.id,firstFragment)
           // addToBackStack(null)
            commit()
        }

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.mainFirstFragment.id,firstFragment)
                commit()
            }
        }
        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.mainFirstFragment.id,secondFragment)
                commit()
            }

        }
    }




}