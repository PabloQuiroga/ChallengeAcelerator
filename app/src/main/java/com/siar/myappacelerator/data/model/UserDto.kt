package com.siar.myappacelerator.data.model

import com.google.gson.annotations.SerializedName
import com.siar.myappacelerator.domain.model.Address
import com.siar.myappacelerator.domain.model.Company
import com.siar.myappacelerator.domain.model.Geo
import com.siar.myappacelerator.domain.model.User

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 10/02/2024
 *
 *****/
data class UserDto(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("username")
    var username: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("address")
    var address: AddressDto,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("website")
    var website: String,
    @SerializedName("company")
    var company: CompanyDto
){
    fun toDomain(): User = User(
        id, name, username, email, address.toDomain(), phone, website, company.toDomain()
    )
}

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
