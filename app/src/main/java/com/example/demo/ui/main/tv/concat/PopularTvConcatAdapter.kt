package com.example.demo.ui.main.tv.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.core.BaseConcatHolder
import com.example.demo.databinding.PopularMoviesRowBinding
import com.example.demo.ui.main.tv.TvAdapter

class PopularTvConcatAdapter(private val tvShowAdapter: TvAdapter) :
    RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = PopularMoviesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is ConcatViewHolder -> holder.bind(tvShowAdapter)
            else -> throw IllegalArgumentException("No viewholder to show this data, did you forgot to add it to the onBindViewHolder?")
        }
    }

    override fun getItemCount(): Int = 1


    private inner class ConcatViewHolder(private val binding: PopularMoviesRowBinding) :
        BaseConcatHolder<TvAdapter>(binding.root) {
        override fun bind(adapter: TvAdapter) {
            binding.rvPopularMovies.adapter = adapter
        }
    }

}
