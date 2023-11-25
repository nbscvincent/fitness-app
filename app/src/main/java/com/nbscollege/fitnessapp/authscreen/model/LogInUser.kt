package com.nbscollege.fitnessapp.authscreen.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    val username: String,
    var password: String,
    val weight: Float,
    val height: Float,
    val age: Int
)

val registeredUsers = mutableListOf<User>(
    User("c", "c", 52f,152f, 5 ),
    User("cayce", "c", 70f,164f, 22 ),
    User("cm", "cm", 89.9f,188f, 21 ),
    User("azzel", "c", 40f,164f, 22 ),
)



val loggedInUsername = mutableListOf<User>(

)
//val account = listOf(
//    User("cayce", "cayce213", "","" )
//)


