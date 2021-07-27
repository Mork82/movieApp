package com.example.demo.ui.main.tv.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.core.BaseConcatHolder
import com.example.demo.databinding.TopRatedMovieRowBinding
import com.example.demo.ui.main.tv.TvAdapter

class TopRatedTvConcatAdapter(private val tvShowAdapter: TvAdapter) :
    RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding =
            TopRatedMovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is ConcatViewHolder-> holder.bind(tvShowAdapter)
                else
            -> throw IllegalArgumentException("No viewholder to show this data, did you forgot to add it to the onBindViewHolder?")
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: TopRatedMovieRowBinding) :
        BaseConcatHolder<TvAdapter>(binding.root) {
        override fun bind(adapter: TvAdapter) {
            binding.rvTopRatedMovies.adapter = adapter
        }
    }
}