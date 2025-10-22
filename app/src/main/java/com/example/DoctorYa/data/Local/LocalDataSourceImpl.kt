package com.example.DoctorYa.data.Local


import com.example.DoctorYa.data.LocalDataSource
import com.example.DoctorYa.data.model.userDto
import com.example.DoctorYa.data.model.userEntity
import com.example.DoctorYa.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor( private val dao: UserDao): LocalDataSource {


    override fun getUsersDb(): Flow<Result<List<userEntity>>> = flow {

            try {
                val users: Flow<List<userEntity>> = dao.getUsers()
                users.map { result: List<userEntity> ->

                    if (!result.isNullOrEmpty())
                    {
                        emit( Result.Success(data = result))
                    }
                    else
                    {

                        emit(Result.Error(message = "Error"))
                    }
                }


            }catch (e: Exception){
                emit(Result.Error(message = e.message.toString()?: "unknow error"))

            }




        }.flowOn(Dispatchers.IO)


   override suspend fun insertUsers(users: List<userEntity>) =  dao.insertUsers(users = users)


    override suspend fun clearDB() = dao.clearDB()



    }















