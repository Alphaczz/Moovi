package com.example.moovi.domain.repository

import com.example.moovi.data.model.Movie

interface MovieRepository
{
    suspend fun getMovies():List<Movie>?
    suspend fun  updateMovies():List<Movie>?



}
