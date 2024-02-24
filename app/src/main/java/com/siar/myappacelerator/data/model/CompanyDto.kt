package com.siar.myappacelerator.data.model

import com.google.gson.annotations.SerializedName
import com.siar.myappacelerator.domain.model.Company

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 24/02/2024
 *
 *****/
data class CompanyDto (
    @SerializedName("name")
    var name: String,
    @SerializedName("catchPhrase")
    var catchPhrase: String
){
    fun toDomain(): Company = Company(
        name, catchPhrase
    )
}
