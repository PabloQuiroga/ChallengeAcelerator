package com.siar.myappacelerator.data

import com.siar.myappacelerator.data.database.dao.UserDao
import com.siar.myappacelerator.data.network.MockService
import com.siar.myappacelerator.domain.model.BasicUser
import com.siar.myappacelerator.domain.model.User
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 10/02/2024
 *****/
@Suppress("UnusedPrivateProperty")
class UserRepository @Inject constructor(
    private val api: MockService,
    private val userDao: UserDao
){

    suspend fun getAllUsersFromApi(): List<User> {
        return api.getUsers()?.map {
            it.toDomain()
        } ?: emptyList()
    }


    suspend fun getAllUsersFromDatabase(): List<BasicUser> {
        return userDao.getAllUsers().map {
            it.toDomain()
        }
    }
}
