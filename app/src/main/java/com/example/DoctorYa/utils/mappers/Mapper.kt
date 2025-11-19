package com.example.DoctorYa.utils.mappers

import com.example.DoctorYa.data.model.userDto
import com.example.DoctorYa.data.model.userEntity
import com.example.DoctorYa.domain.model.user

/*data class userDto(
    @SerializedName("id")  val id: Int,
    @SerializedName("name")  val name: String,
    @SerializedName("username")  val username: String,
    @SerializedName("email")  val email: String
)
*/
fun <T> List<T>.toDomain(mapper: (T)-> user):List<user>{

   return this.map { mapper(it) }

}


fun  List<userDto>.toDomain():List<user>{
    return  this.map { it.toDomain() }
    }



fun userDto.toDomain(): user{

    return user(
        id=id,
        name = name,
        username = username,
        email = email
    )

}

fun userEntity.toDomain():user {

    return user(
        id= id,
        name= name,
        username = username,
        email =email
    )

}

fun user.toEntity():userEntity{

    return userEntity(
        id = id,
        name= name,
        username = username,
        email = email

    )
}
