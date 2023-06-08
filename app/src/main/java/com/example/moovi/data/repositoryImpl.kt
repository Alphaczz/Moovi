package com.example.moovi.data

import android.widget.Toast
import com.example.moovi.data.datasource.MovieCacheDataSource
import com.example.moovi.data.datasource.movieLocalDataSource
import com.example.moovi.data.datasource.movieRemoteDataSource
import com.example.moovi.data.model.Movie
import com.example.moovi.domain.repository.MovieRepository

class repositoryImpl(
    private val movieLocalDataSource: movieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieRemoteDataSource: movieRemoteDataSource
):MovieRepository{
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }



    override suspend fun updateMovies(): List<Movie>? {
        val newListofMovies=getMoviesFromApi()
        movieLocalDataSource.clearALl()
        movieLocalDataSource.saveMoviesToDb(newListofMovies)
        movieCacheDataSource.saveMoviesCache(newListofMovies)
        return newListofMovies








    }


private suspend fun getMoviesFromCache(): List<Movie>? {
    lateinit var movieList: List<Movie>
    try {
        movieList = movieCacheDataSource.getMoviesFromCache()

    } catch (exeception: Exception) {

    }
    if (movieList.size > 0) {
        return movieList
    } else {
        movieList = getMoviesFromRoom()
        movieCacheDataSource.saveMoviesCache(movieList)
    }
    return movieList
}

suspend fun getMoviesFromApi(): List<Movie>
{
    lateinit var moviList: List<Movie>
    try {
        val response= movieRemoteDataSource.getMovies()
        val body=response.body()
        if(body!=null)
        {
            moviList=body.movies
        }

    }catch (exeception:java.lang.Exception)
    {

    }
    return moviList


}

suspend fun getMoviesFromRoom():List<Movie>
{
    lateinit var movieList: List<Movie>
    try {
        movieList=movieLocalDataSource.getMovieFromDb()
    }
    catch (exeception:java.lang.Exception)
    {
    }
    if(movieList.size>0) {
        return movieList
    }
    else{
        movieList=getMoviesFromApi()
        movieLocalDataSource.saveMoviesToDb(movieList)

    }
    return movieList
}
//19
}



