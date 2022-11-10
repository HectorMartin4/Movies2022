package com.example.movies2022.data.remote

import com.example.movies2022.domain.Movie

fun ApiMovieModel.toDomain(): Movie {
    return Movie(this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
    )
}