package com.example.movies2022.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.app.loadUrl
import com.example.movies2022.databinding.ViewItemMovieBinding
import com.example.movies2022.domain.Movie

class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var binding: ViewItemMovieBinding? = null

    fun render(model: Movie) {
        binding = ViewItemMovieBinding.bind(view)
        binding?.apply {
            image.loadUrl(model.poster)
            title.text = model.title
            year.text = model.year.toString()
            genre.text = model.genre
            rate.text = model.rating.toString()
        }

    }

}