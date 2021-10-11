package com.example.kotlinetut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlinetut.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

binding.btnApply.setOnClickListener {

    val name  = binding.etName.text.toString()
    Log.d("printed values","this is the string  name ${name}")
    val age  = binding.etAge.text.toString().toInt()
    Log.d("printed","this is the string  age ${age}")
    val country = binding.etCountry.text.toString()
    Log.d("printed","this is the string  country ${country}")
    val person = Person(name,age,country)
     Intent(this,SecondActivity::class.java).also {
         it.putExtra("EXTRA_PERSON",person)
         startActivity(
             it
         )
     }
}

        //make toast
//      binding.btnShowToast.setOnClickListener {
//          Toast(this).apply {
//              duration = Toast.LENGTH_LONG
//              view  = layoutInflater.inflate(R.layout.custom_toast,binding.clToastMain) as ConstraintLayout
//              show()
//          }
//          //Toast.makeText(this, "Hi this is the toast!", Toast.LENGTH_LONG).show()
//      }



//            binding.btnOrder.setOnClickListener {
//                val checkedMeetRadioButtonId  = binding.rgMeat.checkedRadioButtonId
//                val meat  = findViewById<RadioButton>(checkedMeetRadioButtonId)
//                val cheese  = binding.cbCheese.isChecked
//                val salad  = binding.cbSalad.isChecked
//                val onion  = binding.cbOnion.isChecked
//
//                val orderString = "you order a burger with: \n" +
//                        " ${meat.text}" +
//                        (if(cheese) "\nCheese" else "") +
//                        (if (salad) "\nSalad" else "") +
//                        (if (onion) "\nOnion " else "")
//             binding.tvOrder.text = orderString
//             }





        //show image when button pressed
//           binding.btnAddImage.setOnClickListener {
//               binding.ivImage.setImageResource(R.drawable.grass)
//           }
        //adition code
//        binding.btnAdd.setOnClickListener {
//            var firstnum = binding.etFirstNumber.text.toString().toInt()
//            var secondnum = binding.etSecondNumber.text.toString().toInt()
//            val result = firstnum + secondnum
//            binding.tvResult.text = result.toString()
//        }
        //counter
//        var count = 0
//        binding.btnCount.setOnClickListener {
//            count ++
//            binding.tvCount.text = "Let's count together: $count"
//        }
        //registration code
//        binding.btnApply.setOnClickListener {
//            val firstName = binding.etFirstName.text.toString()
//            val lastName = bindin
    //            g.etLastName.text.toString()
//            val country = binding.etCountry.text.toString()
//            val birthDate = binding.etBirthDate.text.toString()
//            Log.d("Main Activity","$firstName $lastName , born on $birthDate from country $country")
//        }


    }
}