package com.siar.myappacelerator.domain.model

import com.siar.myappacelerator.data.database.entities.UserEntity

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 23/02/2024
 *
 *****/
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
){
    fun toDatabase(): UserEntity = UserEntity(
        name = name,
        email = email,
        phone = phone,
        company = company.name
    )
}
