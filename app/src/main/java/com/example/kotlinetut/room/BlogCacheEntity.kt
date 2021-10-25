package com.example.kotlinetut.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "user")
//data class UserCacheEntity(
//
//    @PrimaryKey(autoGenerate = false)
//    @ColumnInfo(name = "id")
//    var id:Int,
//
//    @ColumnInfo(name = "name")
//    var name:String,
//
//    @ColumnInfo(email = "email")
//    var email:String,
//
//    @ColumnInfo(picture = "picture")
//    var picture:String,
//
//    @ColumnInfo(phone = "phone")
//    var phone:String,
//
//    @ColumnInfo(name = "token")
//    var token:String,
//
//    ) {
//}


@Entity(tableName = "blogs")
data class BlogCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "body")
    var body:String,

    @ColumnInfo(name = "category")
    var category:String,

    @ColumnInfo(name = "image")
    var image:String,

) {
}

