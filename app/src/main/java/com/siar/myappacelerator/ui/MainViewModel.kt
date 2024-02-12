package com.siar.myappacelerator.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.myappacelerator.data.model.UserModel
import com.siar.myappacelerator.domain.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 09/02/2024
 *****/
@HiltViewModel
class MainViewModel @Inject constructor(
    private val usersUseCase: GetUsersUseCase
): ViewModel() {

    private val _isReady = MutableStateFlow(false)
    val isReady = _isReady.asStateFlow()
/*
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _usersList = MutableStateFlow(listOf<UserModel>())
    val usersList = _usersList.asStateFlow()*/

    init {
        viewModelScope.launch {
            delay(2000L)//mock actions on init
            _isReady.value = true
        }
    }

    /*fun onTextClicked(){
        viewModelScope.launch {
            _isLoading.value = true

            val result = usersUseCase()

            if(!result.isNullOrEmpty()){

                _usersList.value = result
                Log.e("USERMODEL", usersList.value.toString())
                //userModel.postValue(result[0])
            }

            _isLoading.value = false
        }
    }*/
}