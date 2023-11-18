package com.nbscollege.fitnessapp.authscreen.model

data class User(
    val username: String,
    val password: String,
    val weight: Float?,
    val height: Float?,
)

val registeredUsers = mutableListOf<User>(
    User("c", "c", 52f,152f ),
)
//val account = listOf(
//    User("cayce", "cayce213", "","" )
//)


