package com.siar.myappacelerator.domain.model

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 24/02/2024
 *
 *****/
data class BasicUser(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val company: String
)
