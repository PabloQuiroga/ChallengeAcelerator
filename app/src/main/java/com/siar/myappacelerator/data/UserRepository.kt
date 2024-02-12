package com.siar.myappacelerator.data

import com.siar.myappacelerator.data.model.UserModel
import com.siar.myappacelerator.data.model.UserProvider
import com.siar.myappacelerator.data.network.MockService
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 10/02/2024
 *****/
class UserRepository @Inject constructor(
    private val api: MockService
){

    suspend fun getAllUsers(): List<UserModel>?{
        val response = api.getUsers()
        UserProvider.users = response ?: emptyList()
        return response
    }
}