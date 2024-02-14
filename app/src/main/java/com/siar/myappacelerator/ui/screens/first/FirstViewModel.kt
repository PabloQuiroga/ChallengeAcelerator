package com.siar.myappacelerator.ui.screens.first

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.myappacelerator.data.model.UserModel
import com.siar.myappacelerator.domain.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 12/02/2024
 *
 *****/
@HiltViewModel
class FirstViewModel @Inject constructor(
    private val usersUseCase: GetUsersUseCase
): ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _usersList = MutableStateFlow(listOf<UserModel>())
    val usersList = _usersList.asStateFlow()

    fun onTextClicked(){
        viewModelScope.launch {
            _isLoading.value = true

            val result = usersUseCase()

            if(result.isNotEmpty()){
                _usersList.value = result
            }

            _isLoading.value = false
        }
    }
}
