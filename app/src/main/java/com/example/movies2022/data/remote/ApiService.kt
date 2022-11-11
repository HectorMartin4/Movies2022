package com.example.movies2022.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val urlEndPoint = "https://movies-and-shows-api.cyclic.app/"
    private var apiEndPoint: ApiEndPoints

    init {
        apiEndPoint = buildApiEndPoint()
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoint(): ApiEndPoints {
        return buildClient().create(ApiEndPoints::class.java)

    }


    fun getAllMovies(): List<ApiMovieModel> {
        val callMovies = apiEndPoint.getAllMovies()
        val response = callMovies.execute()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }

    fun getMovie(movieId: String): ApiMovieModel? {
        val callMovie = apiEndPoint.findById(movieId)
        val response = callMovie.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}