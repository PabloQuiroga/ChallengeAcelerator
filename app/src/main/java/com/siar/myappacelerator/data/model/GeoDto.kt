package com.siar.myappacelerator.data.model

import com.google.gson.annotations.SerializedName
import com.siar.myappacelerator.domain.model.Geo

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 24/02/2024
 *
 *****/
data class GeoDto (
    @SerializedName("lat")
    var lat: String,
    @SerializedName("lng")
    var lng: String
){
    fun toDomain(): Geo = Geo(
        lat, lng
    )
}
