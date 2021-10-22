package com.example.kotlinetut.ui

import com.example.kotlinetut.repository.MainRepository
import com.example.kotlinetut.retrofit.BlogRetrofit
import com.example.kotlinetut.retrofit.NetworkMapper
import com.example.kotlinetut.room.BlogDao
import com.example.kotlinetut.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ):MainRepository{
        return MainRepository(blogDao,retrofit,cacheMapper,networkMapper)
    }
}