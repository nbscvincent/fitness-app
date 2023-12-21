package com.nbscollege.fitnessapp.authscreen.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "currentUser")
data class CurrentUser(
    @PrimaryKey val userId: Int,
    val username: String,
    var password: String,
    val weight: Float,
    val height: Float,
    val age: Int
)