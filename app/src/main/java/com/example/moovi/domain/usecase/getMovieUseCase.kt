package com.example.moovi.domain.usecase

import com.example.moovi.data.model.Movie
import com.example.moovi.domain.repository.MovieRepository

class getMovieUseCase(private  val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>?=movieRepository.getMovies()



}