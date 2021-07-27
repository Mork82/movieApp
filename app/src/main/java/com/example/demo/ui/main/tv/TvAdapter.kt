package com.example.demo.ui.main.tv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.core.BaseViewHolder
import com.example.demo.data.model.TvShow
import com.example.demo.databinding.MovieItemBinding

class TvAdapter(
    private val tvList: List<TvShow>,
    //private val itemClickListener: OnTvShowClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTvShowClickListener {
        fun onTvShowClick(tvShow: TvShow)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PopularTvShowViewHolder(itemBinding, parent.context)
        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            //itemClickListener.onTvShowClick(tvList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PopularTvShowViewHolder -> holder.bind(tvList[position])
        }
    }

    override fun getItemCount(): Int = tvList.size


    private inner class PopularTvShowViewHolder(val binding: MovieItemBinding, val context: Context) :
        BaseViewHolder<TvShow>(binding.root) {
        override fun bind(item: TvShow) {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.poster_path}")
                .centerCrop().into(binding.imgMovie)
        }

    }

}
