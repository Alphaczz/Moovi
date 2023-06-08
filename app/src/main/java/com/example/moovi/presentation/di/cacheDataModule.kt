package com.example.moovi.presentation.di

import com.example.moovi.data.datasource.MovieCacheDataSource
import com.example.moovi.dataSourceImpl.movieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class cacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource
    {
        return  movieCacheDataSourceImpl()
    }
}