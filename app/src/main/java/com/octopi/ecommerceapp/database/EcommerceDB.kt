package com.octopi.ecommerceapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.octopi.ecommerceapp.database.model.RegisterModel

@Database(entities = [RegisterModel::class],version = 1,exportSchema = false)
abstract class EcommerceDB:RoomDatabase() {

    abstract fun ecommerceDao(): EcommerceDao

    companion object{
        @Volatile
        private var INSTANCE: EcommerceDB?=null

        fun getDatabase(context: Context): EcommerceDB?{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,EcommerceDB::class.java,"ecommerce_app"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE
        }
    }
}