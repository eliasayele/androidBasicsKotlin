package com.example.kotlinetut


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


           // val adapter = TodoAdapter(todoList)
//            binding.rvTodos.adapter = adapter
//            binding.rvTodos.layoutManager = LinearLayoutManager(this@MainActivity)



    }

    override fun onResume() {
        super.onResume()

        var todoList =
            mutableListOf(
                Todo("Follow AndroidDevs", false),
                Todo("Creating app", false),
                Todo("make company grow", false),
                Todo("going to church ", false),
                Todo("visiting family ", false),
                Todo("fly in jungle and lake ", false),
            )
       // binding.rvTodos.adapter = TodoAdapter(todoList)
        val adapter = TodoAdapter(TodoGenerator.getTodos())
        //val adapter = TodoAdapter(TodoGenerator.getTodos())
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)
        binding.btnAddTodo.setOnClickListener {
            Log.d("todoadded","${binding.etTodo.text.toString() }  is the new todo")
            val title = binding.etTodo.text.toString()
            Log.d("todoadded","${title }  is the second new todo")
            val todo  = Todo(title,false)
            todoList.add(todo)
            //adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}