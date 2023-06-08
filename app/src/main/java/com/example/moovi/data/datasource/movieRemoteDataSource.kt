package com.example.moovi.data.datasource

import com.example.moovi.data.model.MovieList
import retrofit2.Response

interface movieRemoteDataSource {
      suspend fun getMovies():Response<MovieList>

}