package com.example.kotlinetut.retrofit.util

interface EntityMapper<Entity,DomainModel> {
    fun mapFromEntity(entity: Entity) :DomainModel
    fun mapToEntity(domainModel: DomainModel) :Entity
}