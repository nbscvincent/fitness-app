package com.nbscollege.fitnessapp.authscreen.model

data class User (
    val username: String,
    val password: String,
    val weight: String,
    val height: String,
)

val registeredUsers = mutableListOf<User>(
    User("cayce", "cayce213", "","" ),
)
//val account = listOf(
//    User("cayce", "cayce213", "","" )
//)


