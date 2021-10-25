package com.example.kotlinetut.repository

import com.example.kotlinetut.model.Blog
import com.example.kotlinetut.retrofit.BlogRetrofit
import com.example.kotlinetut.retrofit.NetworkMapper
import com.example.kotlinetut.retrofit.util.DataState
import com.example.kotlinetut.room.BlogDao
import com.example.kotlinetut.room.CacheMapper

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import java.util.concurrent.Flow
import javax.inject.Inject

class MainRepository
@Inject
constructor
(
    private val blogDao: BlogDao,
  //  private val userDao: UserDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper:CacheMapper,
    private val networkMapper: NetworkMapper

)
{
    suspend fun getBlog() = flow {
        emit(DataState.Loading)
        //delay(1000)
        try {
            val     networkBlogs = blogRetrofit.get()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs){
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))

        } catch (e:Exception){
            emit(DataState.Error(e))
        }
    }


//    suspend fun getUser() = flow {
//        emit(DataState.Loading)
//        //delay(1000)
//        try {
//            val networkBlogs = blogRetrofit.get()
//            val user = networkMapper.mapFromEntityList(networkBlogs)
//            //userDao.insert(cacheMapper.mapToEntity(user))
////            for (blog in user){
////
////            }
//            val cacheUser = userDao.get()
//           // val cachedBlogs = blogDao.get()
//            //emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
//           // emit(DataState.Success(cacheMapper.mapFromEntityList(cacheUser)))
//
//        } catch (e:Exception){
//            emit(DataState.Error(e))
//        }
//    }

}