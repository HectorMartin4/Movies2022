package com.example.movies2022.data.local

import com.example.app.data.MemDataStore
import com.example.movies2022.domain.Movie

class MovieLocalMemDataSource(private val dataStore: MemDataStore<Movie>): MoviesLocalDataSource {

    override fun save(movies: List<Movie>) {
        movies.forEach{movie ->
            dataStore.save(movie.id, movie)
        }
    }

    override fun getAll() = dataStore.getAll()


    override fun findById(movieId: String) = dataStore.findById(movieId)

}