package com.example.moovi.dataSourceImpl

import com.example.moovi.data.DB.movieDao
import com.example.moovi.data.datasource.MovieCacheDataSource
import com.example.moovi.data.model.Movie

class movieCacheDataSourceImpl:MovieCacheDataSource
{
    private var movieList= ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie>
    {
        return movieList
    }

    override suspend fun saveMoviesCache(movie: List<Movie>) {
        movieList.clear()
        movieList=ArrayList(movie)
    }
}