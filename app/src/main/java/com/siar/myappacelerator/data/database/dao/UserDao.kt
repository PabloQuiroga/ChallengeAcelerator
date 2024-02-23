package com.siar.myappacelerator.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.siar.myappacelerator.data.database.entities.UserEntity

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 23/02/2024
 *
 *****/
@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY name DESC")
    suspend fun getAllUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(users: List<UserEntity>)
}
