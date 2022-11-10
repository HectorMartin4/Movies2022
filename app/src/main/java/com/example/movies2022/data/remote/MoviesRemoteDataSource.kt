package com.example.movies2022.data.remote

import com.example.movies2022.domain.Movie

class MoviesRemoteDataSource {
    private val apiService = ApiService()

    fun getMovies()= apiService.getAllMovies().map{
        it.toDomain()
    }

    fun getMovie(movieId: Int): Movie = apiService.getMovie(movieId)!!.toDomain()
}