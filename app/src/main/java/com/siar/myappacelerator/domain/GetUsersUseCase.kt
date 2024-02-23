package com.siar.myappacelerator.domain

import com.siar.myappacelerator.data.UserRepository
import com.siar.myappacelerator.domain.model.User
import kotlinx.coroutines.delay
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 10/02/2024
 *****/
@Suppress("MagicNumber") // only for demo
class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(): List<User> {
        delay(2000)
        return repository.getAllUsersFromApi()
    }
}
