package com.example.moovi.presentation.di

import com.example.moovi.data.api.tmdbService
import com.example.moovi.data.datasource.movieRemoteDataSource
import com.example.moovi.dataSourceImpl.remoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class remotedataModule(private val api_key:String)
{
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: tmdbService):movieRemoteDataSource
    {
        return remoteDataSourceImpl(tmdbService, api_key)
    }
}