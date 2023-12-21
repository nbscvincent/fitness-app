package com.nbscollege.fitnessapp.authscreen.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey val userId: Int,
    val username: String,
    var password: String,
    val weight: Float,
    val height: Float,
    val age: Int
) {

}

val registeredUsers = mutableListOf<User>(

)





val loggedInUsername = mutableListOf<User>(

)
//val account = listOf(
//    User("cayce", "cayce213", "","" )
//)


