package com.siar.myappacelerator.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.siar.myappacelerator.util.PREFERENCES_NAME
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
//private const val PREFERENCES_NAME = "preferences_name"

private val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)

class Preferences @Inject constructor(
    private val context: Context
) {

    suspend fun setNameValue(key: String) {
        context.dataStore.edit {
            it[stringPreferencesKey(PREFERENCES_NAME)] = key
        }
    }

    suspend fun getNameValue(): String? {
        return context.dataStore.data.first()[stringPreferencesKey(PREFERENCES_NAME)]
    }
}
