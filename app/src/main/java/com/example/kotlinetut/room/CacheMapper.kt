package com.example.kotlinetut.room

import com.example.kotlinetut.model.Blog

import com.example.kotlinetut.retrofit.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():EntityMapper<BlogCacheEntity,Blog>{
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }


    fun   mapFromEntityList(entities:List<BlogCacheEntity>) :List<Blog>{
        return entities.map {
            mapFromEntity(it)
        }
    }
}


//class UserCacheMapper
//@Inject
//constructor():EntityMapper<UserCacheEntity,User>{
//    override fun mapFromEntity(entity: UserCacheEntity): User {
//        return User(
//             id = entity.id,
//            token = entity.token,
//            name = entity.name,
//            email = entity.email,
//            picture = entity.picture,
//            phone = entity.phone
//        )
//    }
//
//    override fun mapToEntity(domainModel: User): UserCacheEntity {
//        return UserCacheEntity(
//             id = domainModel.id,
//            token = domainModel.token,
//            name = domainModel.name,
//            email = domainModel.email,
//            picture = domainModel.picture,
//            phone = domainModel.phone
//
//        )
//    }
//
//
////    fun   mapFromEntityList(entities:List<BlogCacheEntity>) :List<Blog>{
////        return entities.map {
////            mapFromEntity(it)
////        }
////    }
//
//}
