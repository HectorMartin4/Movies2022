package com.example.movies2022.data.local.dataBase

import androidx.room.*

const val MOVIES_TABLE_NAME = "movies"
const val MOVIE_ID = "id"


@Entity(tableName = MOVIES_TABLE_NAME)
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = MOVIE_ID) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "plot") val plot: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "rating") val rating: Float,
    @ColumnInfo(name = "year") val year: Int,
    @ColumnInfo(name = "poster") val poster: String,

)
