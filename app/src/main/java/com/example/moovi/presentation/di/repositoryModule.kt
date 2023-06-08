package com.example.moovi.presentation.di

import com.example.moovi.data.datasource.MovieCacheDataSource
import com.example.moovi.data.datasource.movieLocalDataSource
import com.example.moovi.data.datasource.movieRemoteDataSource
import com.example.moovi.data.repositoryImpl
import com.example.moovi.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class repositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepo(movieRemoteDataSource: movieRemoteDataSource,
                         movieCacheDataSource: MovieCacheDataSource,
                         localDataSource: movieLocalDataSource):MovieRepository
    {
        return repositoryImpl(localDataSource,movieCacheDataSource,movieRemoteDataSource)
    }
}