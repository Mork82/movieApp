package com.example.demo.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.core.BaseViewHolder
import com.example.demo.data.model.Movie
import com.example.demo.databinding.MovieItemBinding

class UpcomingMoviesAdapter(
    private val upcomingMoviesList: List<Movie>,
    private val itemClickListener: OnMovieClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun onMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = UpcomingMoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onMovieClick(upcomingMoviesList[position])
        }

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is UpcomingMoviesViewHolder -> holder.bind(upcomingMoviesList[position])
        }
    }

    override fun getItemCount(): Int = upcomingMoviesList.size

    private inner class UpcomingMoviesViewHolder(
        val binding: MovieItemBinding,
        val context: Context
    ) : BaseViewHolder<Movie>(binding.root) {
        override fun bind(item: Movie)  {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.backdrop_path}").centerCrop().into(binding.imgMovie)
        }
    }
}