package com.example.DoctorYa.di

import com.example.DoctorYa.data.FireBaseDataSource
import com.example.DoctorYa.data.firebase.FirebaseDataSourceImpl


import com.example.DoctorYa.utils.helpers.FirebaseHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton





@Module
@InstallIn(SingletonComponent::class)
object fireBaseModule {

    @Singleton
    @Provides
    fun provideFirebaseHelper(): FirebaseHelper = FirebaseHelper()

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireBaseDataSource(auth: FirebaseAuth): FireBaseDataSource = FirebaseDataSourceImpl(auth)

}