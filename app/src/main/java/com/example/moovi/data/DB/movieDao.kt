package com.example.moovi.data.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moovi.data.model.Movie

@Dao
interface movieDao
{
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveMovies(movie: List<Movie>)

  @Query("Delete from popular_movies")
  suspend fun deleteAllMovies()

  @Query("Select * from popular_movies")
  suspend fun getAllMovies():List<Movie>

}