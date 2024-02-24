package com.siar.myappacelerator.ui.screens.first

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.myappacelerator.domain.usecases.GetUsersFromApi
import com.siar.myappacelerator.domain.model.User
import com.siar.myappacelerator.domain.usecases.SetNameToPreferences
import com.siar.myappacelerator.util.EMPTY_RESPONSE_MESSAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 23/02/2024
 *
 *****/
@HiltViewModel
class FirstViewModel @Inject constructor(
    private val usersUseCase: GetUsersFromApi,
    private val preferencesUseCase: SetNameToPreferences
): ViewModel() {
    var uiState: FirstUiState by mutableStateOf(FirstUiState.Loading)
        private set

    init {
        getUsersList()
    }

    private fun getUsersList(){
        viewModelScope.launch {
            uiState = FirstUiState.Loading

            uiState = try {
                val result = usersUseCase()

                if (result.isNotEmpty()){
                    setDataResult(result)
                } else {
                    FirstUiState.Error(setEmptyResult())
                }
            } catch (e: IOException){
                FirstUiState.Error(e.message ?: e.toString())
            }
        }
    }

    private suspend fun setDataResult(response: List<User>): FirstUiState{
        preferencesUseCase(response[0].name)
        return FirstUiState.Success(response)
    }

    private fun setEmptyResult(): String{
        return EMPTY_RESPONSE_MESSAGE
    }
}

