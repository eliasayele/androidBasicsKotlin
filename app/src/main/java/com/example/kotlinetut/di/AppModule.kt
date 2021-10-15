package com.example.kotlinetut.di

import android.content.Context
import androidx.room.Room
import com.example.kotlinetut.db.RunningDatabase
import com.example.kotlinetut.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //tels we want to inject sth as the application lifecycle is exist
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(
    @ApplicationContext app:Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db:RunningDatabase) = db.getRunDao()

}