package com.example.movies2022.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {
    @GET("movies")
    fun getAllMovies(): Call<List<ApiMovieModel>>

    @GET("movies/{Id}")
    fun findById(@Path("Id") id: String): Call<ApiMovieModel>
}
