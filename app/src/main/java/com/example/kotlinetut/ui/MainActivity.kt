package com.example.kotlinetut.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.activity.viewModels

import androidx.lifecycle.Observer
import com.example.kotlinetut.databinding.ActivityMainBinding
import com.example.kotlinetut.model.Blog
import com.example.kotlinetut.retrofit.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlobEvents)
    }

    private fun  subscribeObservers() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Blog>> -> {
                    displayProgressBar(false)
                    appendBlogTitles(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        }
      )
    }

    private fun displayError(message:String?){
        if (message != null){
            binding.text.text = message
        }
        else {
            binding.text.text = "Unknown Error"
        }
    }
    private fun displayProgressBar(isDisplayed:Boolean){
         binding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private  fun appendBlogTitles(blogs:List<Blog>){
        val sb = StringBuilder()
        for (blog in blogs){
            sb.append(blog.title + "\n" )
        }
        binding.text.text = sb.toString();
    }
}