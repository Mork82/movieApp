package com.example.demo.data.local

import com.example.demo.application.AppConstants
import com.example.demo.data.model.MovieEntity
import com.example.demo.data.model.MovieList
import com.example.demo.data.model.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {
    suspend fun getUpcomingMovies(): MovieList {
        return movieDao.getAllMovie().filter { it.movie_type == "upcoming" }.toMovieList()
    }

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovie().filter { it.movie_type == "top_rated" }.toMovieList()
    }

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovie().filter { it.movie_type == "popular" }.toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity) {
        movieDao.saveMovie(movie)
    }
}