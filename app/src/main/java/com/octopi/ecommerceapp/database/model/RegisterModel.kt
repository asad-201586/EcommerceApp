package com.octopi.ecommerceapp.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "signup_table")
data class RegisterModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "user_name") var userName: String,
    @ColumnInfo(name = "user_phone_number") var phoneNumber: String,
    @ColumnInfo(name = "user_email") var email: String,
    @ColumnInfo(name = "password") var password: String,
)
