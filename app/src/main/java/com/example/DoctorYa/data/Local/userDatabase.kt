package com.example.DoctorYa.data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.DoctorYa.data.model.userEntity


@Database(entities = [userEntity::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract  fun getUserDao(): UserDao

}