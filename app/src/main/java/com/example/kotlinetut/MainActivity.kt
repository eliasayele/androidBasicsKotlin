package com.example.kotlinetut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment

import com.example.kotlinetut.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import android.R
import android.view.View

import com.google.android.material.bottomnavigation.BottomNavigationView





class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)

          setContentView(binding.root)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        val navigation = findViewById<View>(binding.bottomNavigationView.id) as BottomNavigationView
        setCurrentFragment(firstFragment)
        navigation.setOnItemSelectedListener {
            when(it.itemId) {
                com.example.kotlinetut.R.id.miHome -> setCurrentFragment(firstFragment)
                com.example.kotlinetut.R.id.miMessages -> setCurrentFragment(secondFragment)
                com.example.kotlinetut.R.id.miProfile -> setCurrentFragment(thirdFragment)
            }
            true
        }
        navigation.getOrCreateBadge(com.example.kotlinetut.R.id.miMessages).apply {
            number = 10
            //isVisible = true
        }

    }


    private fun setCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(binding.flFragment.id,fragment)
            commit()
        }
    }
}