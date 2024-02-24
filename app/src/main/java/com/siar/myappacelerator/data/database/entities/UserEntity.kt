package com.siar.myappacelerator.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.siar.myappacelerator.domain.model.BasicUser

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 23/02/2024
 *
 *****/
@Entity(tableName = "user_table")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "mail")
    val email: String,

    @ColumnInfo(name = "phone_number")
    val phone: String,

    @ColumnInfo(name = "company_name")
    val company: String
){
    fun toDomain(): BasicUser = BasicUser(
        id, name, email, phone, company
    )
}
