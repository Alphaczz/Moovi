package com.example.moovi.domain.usecase

import com.example.moovi.data.model.Movie
import com.example.moovi.domain.repository.MovieRepository

class updateMovieUseCase (private  val movieRepository: MovieRepository){
    suspend fun execute():List<Movie>?=movieRepository.updateMovies()

}