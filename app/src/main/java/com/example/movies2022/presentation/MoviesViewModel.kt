package com.example.movies2022.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies2022.domain.GetMoviesFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel(private val moviesFeedUseCase: GetMoviesFeedUseCase) :
    ViewModel() {

    fun obtainMovies(callback: MoviesCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val movie = moviesFeedUseCase.execute()
            withContext(Dispatchers.Main) {
                callback.onCall(movie)
            }
        }
    }
}