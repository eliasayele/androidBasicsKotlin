package com.example.kotlinetut.ui

import androidx.hilt.Assisted
import androidx.lifecycle.*
import com.example.kotlinetut.model.Blog
import com.example.kotlinetut.repository.MainRepository
import com.example.kotlinetut.retrofit.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject
 constructor(
    private val mainRepository: MainRepository,
private val savedStateHandle:SavedStateHandle
):ViewModel(),LifecycleObserver {

    private  val _dataState:MutableLiveData<DataState<List<Blog>>> = MutableLiveData()
    val dataState:LiveData<DataState<List<Blog>>> get() = _dataState

    fun setStateEvent(mainStateEvent:MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                MainStateEvent.GetBlobEvents -> {
                    mainRepository.getBlog()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                MainStateEvent.None -> {
                    //who cares says the teacher
                }
            }
        }
    }
}

sealed class MainStateEvent{
    object GetBlobEvents:MainStateEvent()
    object None:MainStateEvent()
}