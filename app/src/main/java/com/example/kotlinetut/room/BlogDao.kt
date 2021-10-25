package com.example.kotlinetut.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogDao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insert(blogEntity:BlogCacheEntity):Long

@Query("SELECT * FROM blogs")
suspend fun get():List<BlogCacheEntity>

}

//@Dao
//interface UserDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(userEntity:UserCacheEntity):Long
//
//    @Query("SELECT * FROM user")
//    suspend fun get():UserCacheEntity
//
//}