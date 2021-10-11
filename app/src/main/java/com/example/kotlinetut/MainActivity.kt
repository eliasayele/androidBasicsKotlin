package com.example.kotlinetut


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        //creating dialog and show when button pressed
       val addContactDialog = AlertDialog.Builder(this)
           .setTitle("Add Contact")
           .setMessage("Do You want to add Mr Bini To your contact list? ")
           .setIcon(R.drawable.ic_addcontact)
           .setPositiveButton("Yes"){  _,_ ->
             Toast.makeText(this,"You added mr poop to the list",Toast.LENGTH_LONG).show()
           }
           .setNegativeButton("No") { _,_ ->
               Toast.makeText(this,"you didn't add Mr poop to your contact list",Toast.LENGTH_LONG).show()
           }.create()

        //creating dialog and
        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog  = AlertDialog.Builder(this)
            .setTitle("Choose one of these option")
            .setSingleChoiceItems(options,0){ dialogInterface,i ->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Accept"){  _,_ ->
                Toast.makeText(this,"You accepted the SingleChoiceDialog",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline") { _,_ ->
                Toast.makeText(this,"you declined the SingleChoiceDialog",Toast.LENGTH_LONG).show()
            }.create()
        val multipleChoiceDialog  = AlertDialog.Builder(this)
            .setTitle("Choose one of these option")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){ _, i, isChecked ->
                if(isChecked){
                Toast.makeText(this, "You Checked ${options[i]}", Toast.LENGTH_LONG).show()

                }else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_LONG).show()
                }
            }
            .setPositiveButton("Accept"){  _,_ ->
                Toast.makeText(this,"You accepted the MultiChoiceDialog",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline") { _,_ ->
                Toast.makeText(this,"you declined the MultiChoiceDialog",Toast.LENGTH_LONG).show()
            }.create()
        //creating application offers in localization
        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }
        binding.btnDialog2.setOnClickListener {
             singleChoiceDialog.show()
        }
        binding.btnDialog3.setOnClickListener {
            multipleChoiceDialog.show()
        }


    }

}