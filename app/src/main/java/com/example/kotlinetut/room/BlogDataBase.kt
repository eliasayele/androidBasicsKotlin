package com.example.kotlinetut.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BlogCacheEntity::class],version = 1)
abstract  class BlogDataBase: RoomDatabase() {
    abstract fun blogDao():BlogDao


    companion object {
        const val DATABASE_NAME : String = "blog_db"
    }
}

//@Database(entities = [UserCacheEntity::class],version = 1)
//abstract  class UserDataBase: RoomDatabase() {
//
//    abstract fun userDao():UserDao
//
//    companion object {
//        const val DATABASE_NAME : String = "user"
//    }
//}
