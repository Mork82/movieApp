package com.example.demo.domain.tvshow

import com.example.demo.data.model.TvShowList

interface TvShowRepository {
    suspend fun getTopRatedTvShow():TvShowList
    suspend fun getPopularTvShow():TvShowList
}