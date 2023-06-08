package com.example.moovi.presentation.di

import com.example.moovi.data.DB.movieDao
import com.example.moovi.data.datasource.movieLocalDataSource
import com.example.moovi.dataSourceImpl.movieLocalDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class localDataModule()
{
    @Singleton
    @Provides
    fun provideLocalModule(movieDao: movieDao):movieLocalDataSource
    {
        return movieLocalDataSourceImp(movieDao)
    }
}