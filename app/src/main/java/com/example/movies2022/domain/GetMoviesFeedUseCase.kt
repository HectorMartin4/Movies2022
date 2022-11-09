package com.example.movies2022.domain

class GetMoviesFeedUseCase(val repository: MoviesRepository) {

    fun execute(): List<Movie>{
        return repository.getAllMovies()
    }
}