package com.lifeplusbd.lifeplusbd.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @NonNull
    @PrimaryKey
    val id: Int,
    val name: String?,
    val password: String?,
    val email: Double,
    val user_name: String
)