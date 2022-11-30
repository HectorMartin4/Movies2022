package com.example.movies2022.presentation

import android.content.Context
import android.content.SharedPreferences
import com.example.movies2022.data.MoviesDataRepository
import com.example.movies2022.data.local.dataBase.MovieDbLocalDataSource
import com.example.movies2022.data.remote.MoviesRemoteDataSource
import com.example.movies2022.domain.GetMoviesFeedUseCase

class MoviesFactory {

    companion object {
        fun getViewModel(
            context: Context,
            sharedPreferences: SharedPreferences
        ): MoviesViewModel {
            return MoviesViewModel(
                GetMoviesFeedUseCase(
                    MoviesDataRepository(
                        MovieDbLocalDataSource(context), MoviesRemoteDataSource()

                    )
                )
            )
        }
    }
}