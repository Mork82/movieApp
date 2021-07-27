package com.example.demo.domain

import com.example.demo.application.AppConstants
import com.example.demo.data.model.MovieList
import com.example.demo.data.model.TvShowList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query ("api_key") apiKey: String): MovieList

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query ("api_key") apiKey: String): MovieList

    @GET("movie/popular")
    suspend fun getPopulardMovies(@Query ("api_key") apiKey: String): MovieList

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(@Query ("api_key") apiKey: String): TvShowList

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query ("api_") apiKey:String): TvShowList
}



object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}