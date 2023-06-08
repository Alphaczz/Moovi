package com.example.moovi.data.datasource

import com.example.moovi.data.model.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesCache(movie: List<Movie>)
}