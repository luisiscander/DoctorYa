package com.example.DoctorYa.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "users_table")
data class userEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("user_name") val username: String,
    @ColumnInfo("email") val email: String
)

