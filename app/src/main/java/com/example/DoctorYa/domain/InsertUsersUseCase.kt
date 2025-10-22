package com.example.DoctorYa.domain

import com.example.DoctorYa.data.Repository
import com.example.DoctorYa.data.model.userEntity
import javax.inject.Inject

class InsertUsersUseCase @Inject constructor(private val repo: Repository) {



   suspend operator  fun invoke (users: List<userEntity>) = repo.insertUsers(users = users)

}