package com.octopi.ecommerceapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.octopi.ecommerceapp.database.model.RegisterModel

@Dao
interface EcommerceDao {


    /**
     * SIGN_UP
     * USER
     */
    @Insert
    fun addNewUser(raw: RegisterModel): Long

    /**
     * SIGN_IN
     * USER
     */
    @Query("select * from signup_table where user_email = :email and password = :password")
    fun getUser(email: String, password: String): List<RegisterModel>

}