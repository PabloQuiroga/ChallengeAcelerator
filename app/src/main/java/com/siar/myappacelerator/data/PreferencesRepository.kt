package com.siar.myappacelerator.data

import com.siar.myappacelerator.data.local.Preferences
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
class PreferencesRepository @Inject constructor(
    private val preferences: Preferences
) {
    suspend fun setPreferencesName(key: String){
        preferences.setNameValue(key)
    }
    suspend fun getPreferencesName(): String?{
        return preferences.getNameValue()
    }
}
