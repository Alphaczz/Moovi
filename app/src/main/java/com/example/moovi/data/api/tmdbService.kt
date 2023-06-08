package com.example.moovi.data.api

import com.example.moovi.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface tmdbService
{
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        )
        apiKey:String
    ):Response<MovieList>
}