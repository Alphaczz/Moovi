package com.example.moovi.dataSourceImpl

import com.example.moovi.data.DB.movieDao
import com.example.moovi.data.datasource.movieLocalDataSource
import com.example.moovi.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class movieLocalDataSourceImp(private val movieDao: movieDao):movieLocalDataSource
{
    override suspend fun getMovieFromDb(): List<Movie> {
       return movieDao.getAllMovies()
    }

    override suspend fun saveMoviesToDb(movies: List<Movie>) {
       CoroutineScope(Dispatchers.IO).launch{
          movieDao.saveMovies(movies)
       }
    }

    override suspend fun clearALl() {
        CoroutineScope(Dispatchers.IO).launch{
            movieDao.deleteAllMovies()
        }
    }

}