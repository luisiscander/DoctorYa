package com.example.DoctorYa.di

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import com.example.DoctorYa.data.Local.LocalDataSourceImpl
import com.example.DoctorYa.data.Local.UserDao
import com.example.DoctorYa.data.Local.UserDatabase
import com.example.DoctorYa.data.LocalDataSource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule{


   @Provides
   @Singleton
   fun provideDataBase(@ApplicationContext context: Context):UserDatabase = Room.databaseBuilder(context = context,
       UserDatabase::class.java,"users_db").build()


    @Provides
    @Singleton
    fun provideDao(db: UserDatabase): UserDao = db.getUserDao()

    @Provides
    @Singleton
    fun provideLocalDataSource( dao: UserDao) : LocalDataSource = LocalDataSourceImpl(dao = dao)

}