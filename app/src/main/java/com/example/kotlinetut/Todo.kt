package com.example.kotlinetut

data class Todo ( val  title:String, val isChecked:Boolean)

object  TodoGenerator{
    fun  getTodos():List<Todo>{

        val todo1  = Todo("Follow AndroidDevs", false)
        val todo2  =  Todo("Creating app", false)
        var todo3  = Todo("make company grow", false)
        var todo4  =   Todo("going to church ", false)
        var todo5 =   Todo("visiting family ", false)
        var todo6  =  Todo("fly in jungle and lake ", false)

        return  arrayListOf(todo1,todo2,todo3,todo4,todo5,todo6)
    }
}