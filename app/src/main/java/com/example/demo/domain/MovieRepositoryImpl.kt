package com.example.demo.domain

import com.example.demo.data.model.MovieList
import com.example.demo.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(private val dataSource: RemoteMovieDataSource): MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()
    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()
    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()
}