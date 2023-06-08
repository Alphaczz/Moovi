package com.example.moovi.dataSourceImpl

import com.example.moovi.data.api.tmdbService
import com.example.moovi.data.datasource.movieRemoteDataSource
import com.example.moovi.data.model.Movie
import com.example.moovi.data.model.MovieList
import retrofit2.Response

class remoteDataSourceImpl(private val tmdbService: tmdbService,private val api_key:String) :movieRemoteDataSource
{
    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(api_key)
}