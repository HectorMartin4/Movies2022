package com.example.movies2022.data.local.dataBase

import com.example.movies2022.data.remote.toDomain
import com.example.movies2022.domain.Movie

fun MovieEntity.toDomain():Movie{
    return Movie(
        this.id,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster)
}


fun Movie.toEntity():MovieEntity{
    return MovieEntity(
        this.id,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster)
}

