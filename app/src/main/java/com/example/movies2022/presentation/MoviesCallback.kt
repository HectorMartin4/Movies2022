package com.example.movies2022.presentation

import com.example.movies2022.domain.Movie

interface MoviesCallback {
    fun onCall(movie: List<Movie>)

}