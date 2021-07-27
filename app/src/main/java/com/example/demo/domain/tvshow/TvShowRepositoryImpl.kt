package com.example.demo.domain.tvshow

import com.example.demo.data.model.TvShowList
import com.example.demo.data.remote.RemoteTvShowDataSource

class TvShowRepositoryImpl(private val dataSource: RemoteTvShowDataSource):TvShowRepository {

    override suspend fun getTopRatedTvShow(): TvShowList {
        return dataSource.getTopRatedTvShow()
    }

    override suspend fun getPopularTvShow(): TvShowList {
       return dataSource.getPopularTvShow()
    }
}