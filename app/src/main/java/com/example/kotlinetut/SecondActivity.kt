package com.example.kotlinetut

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinetut.databinding.ActivityMainBinding
import com.example.kotlinetut.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_second)
        var binding  = ActivitySecondBinding.inflate(layoutInflater)
        var view  = binding.root
         setContentView(view)
        binding.btnBack.setOnClickListener {
            finish()
        }

    }
}