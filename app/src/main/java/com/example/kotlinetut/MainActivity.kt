package com.example.kotlinetut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment

import com.example.kotlinetut.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
//import com.example.kotlinetut.R
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)

          setContentView(binding.root)
        toggle   = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()///meaning ready to use

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
           when(it.itemId){
               R.id.miItem1 -> Toast.makeText(applicationContext,"Clicked Item 1", Toast.LENGTH_LONG).show()
               R.id.miItem2 -> Toast.makeText(applicationContext,"Clicked Item 2", Toast.LENGTH_LONG).show()
               R.id.miItem3 -> Toast.makeText(applicationContext,"Clicked Item 3", Toast.LENGTH_LONG).show()
           }
           true
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}