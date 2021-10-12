package com.example.kotlinetut


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.example.kotlinetut.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)
          var view = binding.root
          setContentView(view)
            ///manipulating spinner\\
        ///we can create in two ways the first one is like this in code we provide the list
//        val customList  =  listOf<String>("First","Second", "Third","Last")
//        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,customList)
//        binding.spMonths.adapter = adapter
  ///the second one is we provide in values folder in string file and addapt it in xml
           binding.spMonths.onItemSelectedListener  = object :AdapterView.OnItemSelectedListener {

            override fun onItemSelected( parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {

            Toast.makeText(this@MainActivity,
                "You selected ${parent?.getItemAtPosition(position).toString()}",
                Toast.LENGTH_LONG).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            //here  nothing selected
             }

        }


    }

}