package com.example.moovi.presentation.di

import com.example.moovi.domain.repository.MovieRepository
import com.example.moovi.domain.usecase.getMovieUseCase
import com.example.moovi.domain.usecase.updateMovieUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class usecaseModule {
    @Provides
    fun getMOvieUsecase(movieRepository: MovieRepository):getMovieUseCase
    {
         return  getMovieUseCase(movieRepository)
    }
    @Provides
    fun updateMovieUSeCase(movieRepository: MovieRepository):updateMovieUseCase
    {
         return  updateMovieUseCase(movieRepository)
    }
}