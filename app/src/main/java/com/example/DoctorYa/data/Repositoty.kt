package com.example.DoctorYa.data

import android.annotation.SuppressLint
import com.example.DoctorYa.data.Local.LocalDataSourceImpl
import com.example.DoctorYa.utils.toDomain
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.Result
import com.example.DoctorYa.data.Remote.RemoteDataSourceImpl
import com.example.DoctorYa.data.model.userDto
import com.example.DoctorYa.data.model.userEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named


class Repository @Inject constructor(
    private val remoteDS: RemoteDataSource,
    private val localDS: LocalDataSource

) {


    fun getUsersFromApi(): Flow<Result<List<user>>> {

        val response: Flow<Result<List<userDto>>> = remoteDS.getAllUsers()

        return response.map { result: Result<List<userDto>> ->

            when (result) {
                is Result.Error -> {
                    Result.Error(message = result.message)
                }

                is Result.Success -> {
                    //val r: List<userDto>? =result.data
                    val data: List<user> =
                        result.data?.map { userdto -> userdto.toDomain() } ?: emptyList()
                    Result.Success(data = data)


                }
            }


        }

    }


    fun getUsersFromLocal(): Flow<Result<List<user>>> {

        val result = localDS.getUsersDb()

        return result.map { listEntity ->

            when (listEntity) {
                is Result.Error -> {

                    Result.Error(message = listEntity.message)
                }

                is Result.Success -> {

                    val data: List<user> =
                        listEntity.data?.map { entity -> entity.toDomain() } ?: emptyList()
                    Result.Success(data = data)
                }
            }
        }


    }


    suspend fun insertUsers(users: List<userEntity>) =
        withContext(Dispatchers.IO) {
            localDS.insertUsers(users = users)
        }


    suspend fun clearDataBase() = withContext(Dispatchers.IO) { localDS.clearDB() }


}
/*

val response: List<user> = dataSource.getAllUsers().map { it.toDomain() }

return  try {
    if (!response.isNullOrEmpty()){

        Result.Success(data = response)
    }
    else{

        Result.Error(message = " There is no data to Show")

    }
}catch (error: Exception){

    Result.Error(message = error.message.toString())

}

*/


/*
val repo= ApiService()

suspend fun getUsersFromApi(): Result<List<user>> {

    return withContext (Dispatchers.IO){
         try {
            val response: List<user>? = repo.getUsers()?.map { it.toDomain() } ?: emptyList()
             if (!response.isNullOrEmpty()) {

                 Result.Success(data = response)
             }
             else{
                 Result.Error(message = " no hay datos qu mostrar ")
             }

        } catch (ex: Exception){
            Result.Error(message = ex.message.toString())

        }
    }
}



*/





