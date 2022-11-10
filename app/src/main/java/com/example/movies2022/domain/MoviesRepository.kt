package com.example.movies2022.domain

interface MoviesRepository {

    fun getAllMovies(): List<Movie>
    fun getMovieById(id: String): Movie?
}