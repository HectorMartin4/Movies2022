package com.example.movies2022.data.local.dataBase

import android.content.Context
import androidx.room.Room
import com.example.app.data.AppDatabase
import com.example.movies2022.data.local.MoviesLocalDataSource
import com.example.movies2022.domain.Movie

class MovieDbLocalDataSource(val applicationContext: Context): MoviesLocalDataSource {

    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "db-movie"
    ).build()

    override fun save(movies: List<Movie>) {
        val entities = movies.map { movie ->
            movie.toEntity()
        }
        db.movieDao().save(*entities.toTypedArray())
    }

    override fun getAll() = db.movieDao().getAll().map { MovieEntity ->
        MovieEntity.toDomain()
    }

    override fun findById(movieId: String): Movie? {
        return db.movieDao().findById(movieId)?.toDomain()
    }


}