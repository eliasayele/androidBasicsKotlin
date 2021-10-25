package com.example.kotlinetut.model


data class User (
    var id:Int = 0,
    var name: String = "",
    var token:String = "",
    var email: String = "",
    var phone: String = "",
    var picture:String = "",
)