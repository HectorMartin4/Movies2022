package com.example.movies2022.data.local

import com.example.movies2022.domain.Movie

interface MoviesLocalDataSource {
    fun save(movies: List<Movie>)
    fun getAll(): List<Movie>
    fun findById(movieId: String): Movie?
}