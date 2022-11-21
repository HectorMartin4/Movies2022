package com.example.movies2022.data

import com.example.movies2022.data.local.dataBase.MovieDbLocalDataSource
import com.example.movies2022.data.remote.MoviesRemoteDataSource
import com.example.movies2022.domain.Movie
import com.example.movies2022.domain.MoviesRepository

class MoviesDataRepository(
    private val localSource: MovieDbLocalDataSource,
    private val remoteSource: MoviesRemoteDataSource
) : MoviesRepository {


    override fun getAllMovies():List<Movie> {
        var movies = localSource.getAll()
        if(movies.isEmpty()){
            movies = remoteSource.getMovies()
            localSource.save(movies)
            return movies
        }
        return movies
    }

    override fun getMovieById(id: String): Movie? {
        var movie = localSource.findById(id)
        if(movie == null){
            movie = remoteSource.getMovie(id)
            return movie
        }
        return movie
    }


}