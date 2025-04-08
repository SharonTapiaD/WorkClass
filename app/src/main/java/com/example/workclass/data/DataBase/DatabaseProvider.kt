package com.example.workclass.data.DataBase

import android.content.Context
import androidx.room.Room

object DatabaseProvider{
    private var instance: AppDataBase? = null

    fun getDatabase(context: Context): AppDataBase{
        return instance ?: synchronized(this){
            val db = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, "app_db"
            ).build()
            instance = db
            db
        }
    }
}