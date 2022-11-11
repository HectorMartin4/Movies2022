package com.example.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movies2022.data.local.dataBase.MovieDao
import com.example.movies2022.data.local.dataBase.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}