package com.example.moovi.presentation.di

import com.example.moovi.domain.usecase.getMovieUseCase
import com.example.moovi.domain.usecase.updateMovieUseCase
import com.example.moovi.presentation.viewModelFactory
import dagger.Module
import dagger.Provides

@Module
class movieModule {
    @MovieScope
    @Provides
    fun provideViewModelFactory(getmovieuseCase: getMovieUseCase,updateMovieUseCase: updateMovieUseCase)
    :viewModelFactory
    {
        return  viewModelFactory(getmovieuseCase,updateMovieUseCase)
    }
}