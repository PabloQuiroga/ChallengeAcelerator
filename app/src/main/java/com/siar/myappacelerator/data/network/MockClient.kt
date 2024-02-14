package com.siar.myappacelerator.data.network

import com.siar.myappacelerator.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 10/02/2024
 *****/
interface MockClient {

    @GET("users")
    suspend fun getAllUsers(): Response<List<UserModel>>
}
