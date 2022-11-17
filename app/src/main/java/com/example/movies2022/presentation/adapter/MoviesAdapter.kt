package com.example.movies2022.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies2022.R
import com.example.movies2022.domain.Movie

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val dataSet: MutableList<Movie> = mutableListOf()

    fun loadList(movies: List<Movie>) {
        dataSet.clear()
        dataSet.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.render(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}