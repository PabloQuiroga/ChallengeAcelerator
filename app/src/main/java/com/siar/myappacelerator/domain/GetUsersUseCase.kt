package com.siar.myappacelerator.domain

import com.siar.myappacelerator.data.UserRepository
import com.siar.myappacelerator.data.model.UserModel
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 10/02/2024
 *****/
class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(): List<UserModel>? {
        return repository.getAllUsers()
    }
}