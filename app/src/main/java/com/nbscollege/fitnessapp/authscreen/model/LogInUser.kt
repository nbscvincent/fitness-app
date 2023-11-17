package com.nbscollege.fitnessapp.authscreen.model

data class User (
    val username: String,
    val password: String,
    val weight: String,
    val height: String,
)

val registeredUsers = mutableListOf<User>(
<<<<<<< Updated upstream
    User("cayce", "cayce213", "","" ),
=======
    User("c", "c", "","" ),
    User("m", "m", "","" ),
>>>>>>> Stashed changes
)
//val account = listOf(
//    User("cayce", "cayce213", "","" )
//)


