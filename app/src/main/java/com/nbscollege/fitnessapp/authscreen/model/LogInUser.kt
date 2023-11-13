package com.nbscollege.fitnessapp.authscreen.model

data class LogInUser (
    val username: String,
    val password: String,
    val weight: String,
    val height: String,
)

val registeredUsers = mutableListOf<LogInUser>()
val account = listOf(
    LogInUser("cayce", "cayce213", "","" )
)


