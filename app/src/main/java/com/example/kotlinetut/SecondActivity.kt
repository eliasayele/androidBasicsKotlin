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
        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        binding.tvPerson.text = person.toString()

        /*
        *
        * */

       // binding.tvPerson.text = getE
//        binding.bt.setOnClickListener {
//            finish()
//        }

    }
}