package com.example.kotlinetut.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.kotlinetut.R
import com.example.kotlinetut.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticFragment:Fragment(R.layout.fragment_statistics) {
    private val  viewModel: MainViewModel by viewModels()

}