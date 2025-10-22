package com.example.DoctorYa.data.Local

import androidx.compose.ui.text.style.LineBreak
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.DoctorYa.data.model.userEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {


    @Query("SELECT * FROM users_table")
     fun getUsers(): Flow<List<userEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertUsers(users: List<userEntity>)

     @Query(" DELETE FROM users_table")
   suspend fun clearDB()


}