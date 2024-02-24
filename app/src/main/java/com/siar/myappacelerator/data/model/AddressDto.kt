package com.siar.myappacelerator.data.model

import com.google.gson.annotations.SerializedName
import com.siar.myappacelerator.domain.model.Address

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 24/02/2024
 *
 *****/
data class AddressDto (
    @SerializedName("street")
    var street: String,
    @SerializedName("suite")
    var suite: String,
    @SerializedName("city")
    var city: String,
    @SerializedName("zipcode")
    var zipcode: String,
    @SerializedName("geo")
    var geo: GeoDto
){
    fun toDomain(): Address = Address(
        street, suite, city, zipcode, geo.toDomain()
    )
}
