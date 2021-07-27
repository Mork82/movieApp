package com.example.demo.data.remote

import com.example.demo.application.AppConstants
import com.example.demo.data.model.TvShowList
import com.example.demo.domain.WebService

class RemoteTvShowDataSource(private val webService: WebService) {

    suspend fun getTopRatedTvShow():TvShowList{
        return webService.getTopRatedTvShow(AppConstants.API_KEY)
    }

    suspend fun getPopularTvShow():TvShowList{
        return webService.getPopularTvShow(AppConstants.API_KEY)
    }
}