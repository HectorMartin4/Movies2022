package com.example.movies2022.domain

data class Movie(
    val id: Int,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: Float,
    val year: Int,
    val poster: String
    )