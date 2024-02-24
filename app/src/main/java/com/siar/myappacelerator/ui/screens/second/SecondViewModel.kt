package com.siar.myappacelerator.ui.screens.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.myappacelerator.domain.usecases.GetNameFromPreferences
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
 * Unused for now
 *
 *****/
@HiltViewModel
class SecondViewModel @Inject constructor(
    private val preferencesUseCase: GetNameFromPreferences
) : ViewModel(){

    private val _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()

    init {
        viewModelScope.launch {
           preferencesUseCase()?.let {
               _userName.value = it
           }
        }
    }
}
