package com.example.movies2022.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies2022.R
import com.example.movies2022.databinding.ActivityMoviesBinding
import com.example.movies2022.domain.Movie
import com.example.movies2022.presentation.adapter.MoviesAdapter

class MoviesActivity : AppCompatActivity() {

    private var binding: ActivityMoviesBinding? = null
    private var moviesAdapter: MoviesAdapter = MoviesAdapter()

    private val viewModel by lazy {
        MoviesFactory.getViewModel(
            applicationContext,
            getSharedPreferences("nombre_shared_pref", MODE_PRIVATE)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        loadMovies()
    }

    private fun setupView() {
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            listMovies.adapter = moviesAdapter
            val verticalLayout = LinearLayoutManager(this@MoviesActivity)
            verticalLayout.orientation = LinearLayoutManager.VERTICAL
            listMovies.layoutManager = verticalLayout
        }
    }

    private fun loadMovies() {
        viewModel.obtainMovies(object : MoviesCallback {
            override fun onCall(movie: List<Movie>) {
                updateList(movie)
            }
        })
    }

    private fun updateList(movies: List<Movie>) {
        moviesAdapter.loadList(movies)
    }

}