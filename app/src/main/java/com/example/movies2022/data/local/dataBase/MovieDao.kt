package com.example.movies2022.data.local.dataBase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface MovieDao {

    @Query("SELECT * FROM $MOVIES_TABLE_NAME")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM $MOVIES_TABLE_NAME WHERE $MOVIE_ID = :id")
    fun findById(id: String): MovieEntity?

    @Insert(onConflict = REPLACE)
    fun save(vararg movie: MovieEntity)
}