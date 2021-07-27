package com.example.demo.data.model

data class TvShow(
    val id: Int = -1,
    val poster_path: String = "",
    val popularity: String = "",
    val backdrop_path: String = "",
    val vote_average: Double = -1.0,
    val overview: String = "",
    val first_air_date: String = "",
    val original_language: String = "",
    val name: String = "",
    val original_name: String = "",
)

data class TvShowList(val results: List<TvShow> = listOf())