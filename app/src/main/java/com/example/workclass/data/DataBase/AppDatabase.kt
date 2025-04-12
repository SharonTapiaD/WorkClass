package com.example.workclass.data.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workclass.data.Dao.AccountDao
import com.example.workclass.data.model.AccountEntity

@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun accountDao(): AccountDao
}