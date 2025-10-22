package com.example.DoctorYa.data.Remote

import androidx.compose.foundation.isSystemInDarkTheme
import com.example.DoctorYa.utils.retrofitHelper
import com.example.DoctorYa.utils.Result

import com.example.DoctorYa.data.RemoteDataSource
import com.example.DoctorYa.data.model.userDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: ApiClient) : RemoteDataSource {



    override  fun getAllUsers(): Flow<Result<List<userDto>>>   = flow {

       try {

            val response: Response<List<userDto>> = api.getUsers()
            if(response.isSuccessful){

                emit(Result.Success(data = response.body()?:emptyList()))

            }else{

               emit(Result.Error(message = " Http: ${response.code()}: ${response.message()}"))
            }

        }catch (e: Exception){
            emit(Result.Error(message = e.localizedMessage?:"Unknow error"))

        }




    }.flowOn(Dispatchers.IO)










    }







        /*
        return withContext(Dispatchers.IO) {
            val response: Response<List<userDto>> = retrofit.getRetrofit().create(ApiClient::class.java).getUsers()
            //val body: List<userDto>? = response.body()
             response.body()?: emptyList()

        }
    }*/


