package com.example.demo.domain

import com.example.demo.data.local.LocalMovieDataSource
import com.example.demo.data.model.MovieList
import com.example.demo.data.model.toMovieEntity
import com.example.demo.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val dataSource: RemoteMovieDataSource,
    private val dataSourceLocal:
    LocalMovieDataSource
): MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList {
         dataSource.getUpcomingMovies().results.forEach { movie->
             dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
         }
        return dataSourceLocal.getUpcomingMovies()
    }
    override suspend fun getTopRatedMovies(): MovieList {
        dataSource.getTopRatedMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("top_rated"))
        }
        return dataSourceLocal.getTopRatedMovies()
    }
    override suspend fun getPopularMovies(): MovieList {
        dataSource.getPopularMovies().results.forEach { movie->
            dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
        }
        return dataSourceLocal.getPopularMovies()
    }
}