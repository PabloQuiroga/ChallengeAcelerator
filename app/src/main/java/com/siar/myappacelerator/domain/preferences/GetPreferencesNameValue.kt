package com.siar.myappacelerator.domain.preferences

import com.siar.myappacelerator.data.PreferencesRepository
import javax.inject.Inject

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 14/02/2024
 *
 *****/
class GetPreferencesNameValue @Inject constructor(
    private val repository: PreferencesRepository
) {
    suspend operator fun invoke() = repository.getPreferencesName()
}
