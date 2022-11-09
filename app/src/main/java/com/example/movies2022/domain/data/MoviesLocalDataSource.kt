package com.example.movies2022.domain.data

import com.example.movies2022.domain.Movie

interface MoviesLocalDataSource {
    fun save(movies: List<Movie>)
    fun getAll(): List<Movie>
    fun findById(movieId: Int): Movie?
    fun delete(movieId: Int)
}