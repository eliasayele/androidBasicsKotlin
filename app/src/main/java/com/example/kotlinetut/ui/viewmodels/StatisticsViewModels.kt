package com.example.kotlinetut.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.kotlinetut.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModels @Inject constructor(
    val mainRepository:MainRepository
) :ViewModel(){
}