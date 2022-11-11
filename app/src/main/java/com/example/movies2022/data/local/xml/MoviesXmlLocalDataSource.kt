package com.example.movies2022.data.local.xml

import android.content.SharedPreferences
import com.example.app.commons.Serializer
import com.example.movies2022.domain.Movie
import com.example.movies2022.data.MoviesLocalDataSource

class MoviesXmlLocalDataSource(
    private val sharedPreferences: SharedPreferences,
    private val jSerializer: Serializer
) : MoviesLocalDataSource
{
    override fun save(movies: List<Movie>) {
        movies.forEach { movie ->
            sharedPreferences.edit().apply {
                putString(
                    movie.id.toString(),
                    jSerializer.toJson(movie, Movie::class.java)
                )
            }.apply()
        }
    }

    override fun getAll(): List<Movie> = sharedPreferences.all.map {
        jSerializer.fromJson(it.value as String, Movie::class.java)
    }

    override fun findById(movieId: String): Movie? {
        return sharedPreferences.getString(movieId.toString(), null)?.let {
            jSerializer.fromJson(it, Movie::class.java)
        }
    }
}