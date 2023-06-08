package com.example.moovi.presentation.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moovi.data.DB.movieDao
import com.example.moovi.data.DB.tmdbDatabase
import com.example.moovi.data.api.tmdbService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class databaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context):tmdbDatabase{
        return Room.databaseBuilder(context,
            tmdbDatabase::class.java,"tmdbclient")
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: tmdbDatabase):movieDao{
        return  tmdbDatabase.movieDao()
    }
}