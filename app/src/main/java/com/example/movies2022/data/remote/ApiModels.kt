package com.example.movies2022.data.remote

data class ApiMovieModel(
    val id: String,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: Float,
    val year: Int,
    val poster: String
)