package com.siar.myappacelerator.ui.screens.first

import com.siar.myappacelerator.domain.model.User

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 23/02/2024
 *
 *****/
sealed interface FirstUiState {
    data class Success(val users: List<User>) : FirstUiState
    object Loading : FirstUiState
    data class Error(val error: String) : FirstUiState
}
