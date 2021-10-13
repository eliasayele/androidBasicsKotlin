package com.example.kotlinetut

import android.content.Context
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
        val sharedPref = getSharedPreferences("name", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val isAdult = binding.cbAdult.isChecked

            editor.apply{
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult",isAdult)
                apply() //editor scope apply
            }

        }
        binding.btnLoad.setOnClickListener {
            val name = sharedPref.getString("name",null)
            val age  = sharedPref.getInt("age",0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            binding.etName.setText(name)
            binding.etAge.setText(age.toString())
            binding.cbAdult.isChecked = isAdult
        }
    }

}