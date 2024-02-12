package com.siar.myappacelerator.data.network

import com.siar.myappacelerator.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 10/02/2024
 *****/
class MockService @Inject constructor(
    private val mockClient: MockClient
){
    suspend fun getUsers(): List<UserModel>?{
        return withContext(Dispatchers.IO){
            val response = mockClient.getAllUsers()
            response.body()
        }
    }
}