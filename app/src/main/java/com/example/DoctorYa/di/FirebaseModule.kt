package com.example.DoctorYa.di

import com.example.DoctorYa.utils.FirebaseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object firebaseModule{

    @Singleton
    @Provides
    fun provideFirebaseHelper(): FirebaseHelper = FirebaseHelper()


}