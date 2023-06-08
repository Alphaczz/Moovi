package com.example.moovi.data.datasource

import com.example.moovi.data.model.Movie

interface movieLocalDataSource {
    suspend fun getMovieFromDb():List<Movie>

    suspend fun saveMoviesToDb(movies:List<Movie>)

    suspend fun  clearALl()
}