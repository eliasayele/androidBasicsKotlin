package com.example.kotlinetut

import android.app.appsearch.GlobalSearchSession
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment

import com.example.kotlinetut.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
//import com.example.kotlinetut.R
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.*
import kotlinx.coroutines.test.withTestContext


class MainActivity : AppCompatActivity() {

private lateinit var binding:ActivityMainBinding
lateinit var toggle:ActionBarDrawerToggle
val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)
        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG,"Starting Coroutine in thread ${Thread.currentThread().name}")
            val networkCallAnswer  = doNetworkCall()
            withContext(Dispatchers.Main){
                Log.d(TAG,"Setting text in thread  ${Thread.currentThread().name}")
                binding.tvThread.text = networkCallAnswer
            }

        }
    }

    suspend fun doNetworkCall():String {
        delay(3000L)
        return "From do Network call block"
    }


}