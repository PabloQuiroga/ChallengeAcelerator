package com.siar.myappacelerator.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.siar.myappacelerator.data.database.dao.UserDao
import com.siar.myappacelerator.data.database.entities.UserEntity

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 23/02/2024
 *
 *****/
@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao
}
