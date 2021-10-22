package com.example.kotlinetut.di

import com.example.kotlinetut.model.Blog
import com.example.kotlinetut.retrofit.BlogNetworkEntity
import com.example.kotlinetut.retrofit.BlogRetrofit
import com.example.kotlinetut.retrofit.NetworkMapper
import com.example.kotlinetut.retrofit.util.EntityMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder():Gson{
        return  GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson:Gson):Retrofit.Builder{
        return  Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder):BlogRetrofit{
        return retrofit
            .build()
            .create(BlogRetrofit::class.java)
    }

}