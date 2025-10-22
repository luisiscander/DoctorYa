package com.example.DoctorYa.di


import com.example.DoctorYa.data.Remote.ApiClient
import com.example.DoctorYa.data.Remote.RemoteDataSourceImpl
import com.example.DoctorYa.data.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RemoteModule{

   const  val  BASE_URL="https://jsonplaceholder.typicode.com/"


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiClient {

        return retrofit.create(ApiClient::class.java)
    }


    @Provides
    @Singleton

    fun provideRemoteDataSource(api: ApiClient): RemoteDataSource = RemoteDataSourceImpl(api)




}