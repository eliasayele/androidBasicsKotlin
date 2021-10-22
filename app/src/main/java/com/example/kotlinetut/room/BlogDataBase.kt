package com.example.kotlinetut.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinetut.model.Blog

@Database(entities = [BlogCacheEntity::class],version = 1)
abstract  class BlogDataBase: RoomDatabase() {
    abstract fun blogDao():BlogDao

    companion object {
        const val DATABASE_NAME : String = "blog_db"
    }
}
