package com.example.kotlinetut.di

import android.content.Context
import androidx.room.Room
import com.example.kotlinetut.model.Blog
import com.example.kotlinetut.room.BlogDao
import com.example.kotlinetut.room.BlogDataBase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context) :BlogDataBase  {
        return Room.databaseBuilder(
            context,
            BlogDataBase::class.java,
            BlogDataBase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun  provideBlogDAO(blogDataBase: BlogDataBase):BlogDao{
        return blogDataBase.blogDao()
    }

//    @Singleton
//    @Provides
//    fun provideUserDb(@ApplicationContext context: Context) :UserDataBase  {
//        return Room.databaseBuilder(
//            context,
//            UserDataBase::class.java,
//            UserDataBase.DATABASE_NAME
//        )
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun  provideUserDAO(userDataBase: UserDataBase):UserDao{
//        return userDataBase.userDao()
//    }

}